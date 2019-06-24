package com.example.demo.controllers;

import com.example.demo.bean.Account;
import com.example.demo.bean.CompanyBase;
import com.example.demo.bean.CompanyHonor;
import com.example.demo.bean.ImgBase;
import com.example.demo.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private ImgBaseService imgBaseService;

    @Autowired
    private CompanyBaseService companyBaseService;

    @Autowired
    private CompanyHonorService companyHonorService;


    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/adminIndex")
    public ModelAndView adminIndex(ModelAndView modelAndView, @Param("username") String username, @Param("password") String password, HttpServletRequest request) {

        //把用户放入session
        Account account=accountService.login(username,password);
        if (account!=null){
            modelAndView.setViewName("/admin/index");
            request.getSession().setAttribute("account",account);
        }else{
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping("/gl_index")
    public ModelAndView gl_index(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/gl_index");
        //加载首页轮播图
        List<ImgBase> imgList = imgBaseService.getImgBaseListByCode("INDEXWHEEL");
        modelAndView.addObject("wheelList", imgList);

        List<ImgBase> secImgLise = imgBaseService.getImgBaseListByCode("XTWHEEL");
        modelAndView.addObject("secImgLise", secImgLise);
        return modelAndView;
    }

    @RequestMapping("/gl_gsjj")
    public ModelAndView gl_gsjj(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/gl_gsjj");
        CompanyBase companyBase=companyBaseService.getCompanyBaseByCode("MAINCOMPANY");
        modelAndView.addObject("company",companyBase);
        ImgBase imgBase=imgBaseService.getImgBaseByCode("COMPANYIMG");
        modelAndView.addObject("companyImg",imgBase);
        return modelAndView;
    }

    @RequestMapping("/gl_gsry")
    public ModelAndView gl_gsry(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/gl_gsry");
        return modelAndView;
    }

    @RequestMapping("/gl_gszl")
    public ModelAndView gl_gszl(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/gl_gszl");
        //gszl信息
        List<ImgBase> yyzzList=imgBaseService.getImgBaseListByCode("GSZL_YYZZ");
        if(null!=yyzzList){
            modelAndView.addObject("yyzz",yyzzList.get(0));
        }


        return modelAndView;
    }
}
