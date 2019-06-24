package com.example.demo.dao;

import com.example.demo.bean.CompanyHonor;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CompanyHonorDao {

    @Select("select * from company_honor")
    List<CompanyHonor> findAll();

    @Update("update company_honor set time=#{time},honor=#{honor} where id=#{id}")
    int update(CompanyHonor companyHonor);

    @Delete("delete from company_honor where id=#{id}")
    int delete(@Param("id") int id);

    @Insert("insert into company_honor (time, honor) values (#{time},#{honor})")
    int insert(CompanyHonor companyHonor);

}
