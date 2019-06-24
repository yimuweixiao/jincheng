package com.example.demo.dao;

import com.example.demo.bean.Achievement;
import com.example.demo.bean.AchievementDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AchievementDao {

    @Select("select * from achievement order by creatdate desc LIMIT #{top}")
    List<Achievement> getAchievementList(@Param("top") int top);

    @Select("select * from achievement where code =#{code} order by creatdate desc")
    List<Achievement> getAchievementByCode(@Param("code") String code);

    @Select("select * from ach_details where ach_id=#{id}")
    List<AchievementDetails> getAchievementDetailById(@Param("id") Integer id);

    @Select("select * from achievement where id=#{id}")
    Achievement getAchievementById(@Param("id") Integer id);
}
