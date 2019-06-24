package com.example.demo.dao;

import com.example.demo.bean.ImgBase;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ImgBaseDao {
    @Select("select * from img_base where id=#{id} LIMIT 1")
    ImgBase getImgBaseById(@Param("id") int id);

    @Select("select * from img_base where code=#{code} LIMIT 1")
    ImgBase getImgBaseByCode(@Param("code")String code);

    @Select("select * from img_base where code =#{code}")
    List<ImgBase> getImgBaseListByCode(@Param("code")String code);

    @Insert("insert into img_base(name, height, width, url,code) values(#{name}, #{height}, #{width}, #{url}, #{code})")
    int insert(ImgBase imgBase);

    @Delete("delete from img_base where id=#{id}")
    int delete(@Param("id") int id);

    @Update("update img_base i set i.name=#{name},i.height=#{height},i.width=#{width},i.url=#{url},i.code=#{code} where i.id=#{id}")
     int update(ImgBase imgBase);
}
