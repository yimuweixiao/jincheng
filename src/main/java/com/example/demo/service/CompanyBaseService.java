package com.example.demo.service;

import com.example.demo.bean.CompanyBase;
import com.example.demo.dao.CompanyBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyBaseService {
    @Autowired
    private CompanyBaseDao companyBaseDao;

    public CompanyBase getCompanyBaseByCode(String code){
        return companyBaseDao.getCompanyBaseByCode(code);
    }

    public int update(CompanyBase companyBase){
        return companyBaseDao.update(companyBase);
    }
}


