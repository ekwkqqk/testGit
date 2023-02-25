package com.example.springboottest.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottest.dto.TestDto;
import com.example.springboottest.entity.MembersEntity;
import com.example.springboottest.mapper.IMembersDao;
import com.example.springboottest.service.ExcelService;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private IMembersDao iMembersDao;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value="/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(value="/test")
    public List<MembersEntity> test() {
        List<MembersEntity> listMembers = iMembersDao.listMembers();
        return listMembers;
    }

    @GetMapping(value="/excel")
    public void excel(HttpServletResponse response) throws Exception {
        excelService.selectExcelList(response);
    }

    @GetMapping(value="/i18n")
    public String i18n() {
        System.out.println(Locale.US);
        System.out.println(Locale.KOREA);
        System.out.println(Locale.KOREAN);
        System.out.println("en_US : " + messageSource.getMessage("enter", null, Locale.US));
        System.out.println("ko_KR : " + messageSource.getMessage("enter", null, null));
        return "확인";
    }
}
