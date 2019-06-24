package com.example.demo.dao;

import com.example.demo.bean.CompanyBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanyBaseDao {
    @Select("select * from company_base where id=(select company_id from companybase_id_code where code=#{code} LIMIT 1)")
    CompanyBase getCompanyBaseByCode(@Param("code") String code);

    @Update("update company_base set name=#{name},introduce=#{introduce},address=#{address},mailbox=#{mailbox},mobile=#{mobile},code=#{code},detailed_introduce=#{detailedIntroduce},address_url=#{addressUrl} where id=#{id}")
    int update(CompanyBase companyBase);
}
