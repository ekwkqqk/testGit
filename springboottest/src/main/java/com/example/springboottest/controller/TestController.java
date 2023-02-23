package com.example.springboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottest.dto.TestDto;
import com.example.springboottest.entity.MembersEntity;
import com.example.springboottest.mapper.IMembersDao;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private IMembersDao iMembersDao;

    @GetMapping(value="/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(value="/test")
    public List<MembersEntity> test() {
        List<MembersEntity> listMembers = iMembersDao.listMembers();
        return listMembers;
    }
}
