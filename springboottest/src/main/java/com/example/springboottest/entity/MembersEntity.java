package com.example.springboottest.entity;


import java.util.Date;
import lombok.Data;

@Data
public class MembersEntity {
    private Long id;
    private String name;
    private Integer age;
    private String roleType;
    private Date createdDate;
    private Date lastModifiedDate;
    private String description;
}
