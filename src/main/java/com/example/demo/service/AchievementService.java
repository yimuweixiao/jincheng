package com.example.demo.service;

import com.example.demo.bean.Achievement;
import com.example.demo.bean.AchievementDetails;
import com.example.demo.bean.CompanyHonor;
import com.example.demo.dao.AchievementDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService{
    @Autowired
    private AchievementDao achievementDao;

    public List<Achievement> getAchievementList(int top){
        return achievementDao.getAchievementList(top);
    }

    public PageInfo<Achievement> getAchievementByCode(Integer pageNum,Integer pageSize,String code){
        PageHelper.startPage(pageNum,pageSize);
        List<Achievement> achievementList=achievementDao.getAchievementByCode(code);
        return new PageInfo<>(achievementList);
    }

    public List<AchievementDetails> getAchievementDetailById(Integer id){
        return achievementDao.getAchievementDetailById(id);
    }

    public Achievement getAchievementById(Integer id){
        return  achievementDao.getAchievementById(id);
    }
}
