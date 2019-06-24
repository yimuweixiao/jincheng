package com.example.demo.dao;

import com.example.demo.bean.Account;
import com.example.demo.bean.Achievement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountDao {
    @Select("select * from account where name=#{name} ")
    Account getAccountByName(@Param("name") String name);

    @Select("select * from account where name=#{name} and password=#{password}")
    Account login(@Param("name") String name,@Param("password") String password);
}
