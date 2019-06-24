package com.example.demo.dao;

import com.example.demo.bean.Achievement;
import com.example.demo.bean.AchievementDetails;
import com.example.demo.bean.ActivityDetails;
import com.example.demo.bean.CompanyActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityDao {
    @Select("select * from company_activity")
    List<CompanyActivity> getCompanyActivityList();

    @Select("select * from act_details where act_id=#{id}")
    List<ActivityDetails> getActivityDetailsById(@Param("id") Integer id);

    @Select("select * from company_activity where id=#{id}")
    CompanyActivity getActivityById(@Param("id") Integer id);
}
