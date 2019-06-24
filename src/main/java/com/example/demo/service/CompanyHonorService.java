package com.example.demo.service;

import com.example.demo.bean.CompanyHonor;
import com.example.demo.dao.CompanyHonorDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyHonorService {
    @Autowired
    private CompanyHonorDao companyHonorDao;

    public PageInfo<CompanyHonor> getPageCompanyHonor(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CompanyHonor> companyHonorList=companyHonorDao.findAll();
        return new PageInfo<>(companyHonorList);
    }

    public List<CompanyHonor> findAll(){
        return companyHonorDao.findAll();
    }

    public int update(CompanyHonor companyHonor){
        return companyHonorDao.update(companyHonor);
    }

    public int delete(int id){
        return companyHonorDao.delete(id);
    }

    public int insert(CompanyHonor companyHonor){
        return companyHonorDao.insert(companyHonor);
    }

}
