package com.example.springboottest.service;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboottest.entity.MembersEntity;

@Service
public class ExcelService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Transactional
    public void selectExcelList(HttpServletResponse response) {

	SqlSession sqlSession = sqlSessionFactory.openSession();

	// 메모리에 100개의 행을 유지합니다. 행의 수가 넘으면 디스크에 적습니다.
	SXSSFWorkbook wb = new SXSSFWorkbook(100);
	Sheet sheet = wb.createSheet();

	try {
		sqlSession.select("listMembers", "", new ResultHandler<MembersEntity>() {
			@Override
			public void handleResult(ResultContext<? extends MembersEntity> context) {
				MembersEntity vo = context.getResultObject();
				Row row = sheet.createRow(context.getResultCount() - 1);
				Cell cell = null;
				cell = row.createCell(0);
				cell.setCellValue(vo.getName());
				cell = row.createCell(1);
				cell.setCellValue(vo.getRoleType());
				cell = row.createCell(2);
				cell.setCellValue(vo.getAge());
			}
		});

		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"test.xlsx\""));
		wb.write(response.getOutputStream());

	} catch(Exception e) {

		response.setHeader("Set-Cookie", "fileDownload=false; path=/");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Content-Type","text/html; charset=utf-8");

		OutputStream out = null;
		try {
			out = response.getOutputStream();
			byte[] data = new String("fail..").getBytes();
			out.write(data, 0, data.length);
		} catch(Exception ignore) {
			ignore.printStackTrace();
		} finally {
			if(out != null) try { out.close(); } catch(Exception ignore) {}
		}

	} finally {
		sqlSession.close();

		// 디스크 적었던 임시파일을 제거합니다.
		wb.dispose();
		try { wb.close(); } catch(Exception ignore) {}
	}
}

}
