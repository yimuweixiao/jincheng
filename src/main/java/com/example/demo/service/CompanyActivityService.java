package com.example.demo.service;

import com.example.demo.bean.ActivityDetails;
import com.example.demo.bean.CompanyActivity;
import com.example.demo.dao.ActivityDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyActivityService {
    @Autowired
    private ActivityDao activityDao;

    public PageInfo<CompanyActivity> getCompanyActivityList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CompanyActivity> activityList=activityDao.getCompanyActivityList();
        return new PageInfo<>(activityList);
    }

    public List<ActivityDetails> getActivityDetailById(Integer id){
        return activityDao.getActivityDetailsById(id);
    }

    public CompanyActivity getActivityById(Integer id){
        return  activityDao.getActivityById(id);
    }
}
