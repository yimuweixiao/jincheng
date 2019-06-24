package com.example.demo.controllers;

import com.example.demo.bean.Achievement;
import com.example.demo.bean.AchievementDetails;
import com.example.demo.bean.CompanyHonor;
import com.example.demo.service.AchievementService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class YjzsController {

    @Autowired
    private AchievementService achievementService;

    @RequestMapping("/yjzs_ggjz")
    public ModelAndView mian_gsjj(ModelAndView modelAndView, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        modelAndView.setViewName("yjzs_ggjz");
        PageInfo<Achievement> achievementPageInfo=achievementService.getAchievementByCode(pageNum,pageSize,"GGJZ");
        modelAndView.addObject("yjzs_name","公共建筑");
        modelAndView.addObject("achievementPageInfo",achievementPageInfo);
        return modelAndView;
    }

    @RequestMapping("/yjzs_jxjt")
    public ModelAndView yjzs_jxjt(ModelAndView modelAndView, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        modelAndView.setViewName("yjzs_jxjt");
        PageInfo<Achievement> achievementPageInfo=achievementService.getAchievementByCode(pageNum,pageSize,"JXJT");
        modelAndView.addObject("yjzs_name","机械交通");
        modelAndView.addObject("achievementPageInfo",achievementPageInfo);
        return modelAndView;
    }

    @RequestMapping("/yjzs_nyhg")
    public ModelAndView yjzs_nyhg(ModelAndView modelAndView, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        modelAndView.setViewName("yjzs_nyhg");
        PageInfo<Achievement> achievementPageInfo=achievementService.getAchievementByCode(pageNum,pageSize,"NYHG");
        modelAndView.addObject("yjzs_name","能源化工");
        modelAndView.addObject("achievementPageInfo",achievementPageInfo);
        return modelAndView;
    }

    @RequestMapping("/yjzsDetail")
    public ModelAndView yjzsDetail(ModelAndView modelAndView, @RequestParam("id") Integer achievementId) {
        modelAndView.setViewName("yjzs_item_details");
        Achievement achievement=achievementService.getAchievementById(achievementId);
        modelAndView.addObject("achievement",achievement);
        List<AchievementDetails> list=achievementService.getAchievementDetailById(achievementId);
        modelAndView.addObject("detailsList",list);
        return modelAndView;
    }
}
