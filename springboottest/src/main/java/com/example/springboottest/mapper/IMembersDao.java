package com.example.springboottest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottest.entity.MembersEntity;

@Mapper
public interface IMembersDao {
    public List<MembersEntity> listMembers();
}
