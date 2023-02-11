package com.example.springboottest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottest.dto.TestDto;

@RestController
public class TestController {
    
    @PostMapping("/test/api")
    public TestDto test(@RequestBody TestDto dto) {
        return dto;
    }
}
