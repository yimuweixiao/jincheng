package com.example.demo.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.*;
import com.example.demo.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ImgBaseService imgBaseService;

    @Autowired
    private CompanyBaseService companyBaseService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private CompanyHonorService companyHonorService;


    @RequestMapping("/")
    public ModelAndView main(ModelAndView modelAndView, HttpSession session) {

        //获取公司logo图片
        ImgBase imgLogo = imgBaseService.getImgBaseByCode("COMPANYLOGO");
        session.setAttribute("imgLogo", imgLogo);
        //从数据库获取三张主轮播图片
        List<ImgBase> imgList = imgBaseService.getImgBaseListByCode("INDEXWHEEL");
        modelAndView.addObject("wheelList", imgList);

        //获取次页轮播图放session
        List<ImgBase> secImgLise = imgBaseService.getImgBaseListByCode("XTWHEEL");
        session.setAttribute("secImgLise", secImgLise);

        //获取公司信息
        CompanyBase companyBase = companyBaseService.getCompanyBaseByCode("MAINCOMPANY");
        //设置公司照片
        ImgBase imgBase = imgBaseService.getImgBaseByCode("COMPANYIMG");
        companyBase.setImgBase(imgBase);
        session.setAttribute("company", companyBase);

        //获取前6个业绩作展示
        List<Achievement> achievementList = achievementService.getAchievementList(6);
        session.setAttribute("bottomWheelList", achievementList);
        //知乎日报接口
        String newsUrl = "http://news-at.zhihu.com/api/2/news/latest";
        List list = new ArrayList();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(newsUrl, String.class);
            String body = responseEntity.getBody();
            JSONObject jsonObject = JSONObject.parseObject(body);
            JSONArray jsonArray = jsonObject.getJSONArray("news");
            String numDate = jsonObject.getString("date");
            Date dateDate = new SimpleDateFormat("yyyyMMdd").parse(numDate);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(dateDate);

            //  int size = jsonArray.size();
            // 拿前四条
            for (int i = 0; i < (jsonArray.size() > 4 ? 4 : jsonArray.size()); i++) {
                JSONObject jsonObjectone = jsonArray.getJSONObject(i);
                IndexNews indexNews = new IndexNews();
                indexNews.setTitle(jsonObjectone.getString("title"));
                indexNews.setUrl(jsonObjectone.getString("share_url"));
                indexNews.setDate(date);
                list.add(indexNews);
            }
            modelAndView.addObject("success", true);
        } catch (Exception e) {
            //接口出错
            System.out.println(e.getMessage() + "-------------");
            modelAndView.addObject("success", false);
        }
        modelAndView.addObject("newsList", list);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    //公司简介
    @RequestMapping("/mian_gsjj")
    public ModelAndView mian_gsjj(ModelAndView modelAndView) {
        modelAndView.setViewName("mian_gsjj");
        return modelAndView;
    }

    @RequestMapping("/main_gsry")
    public ModelAndView main_gsry(ModelAndView modelAndView, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        modelAndView.setViewName("main_gsry");
        //查询分页荣誉数据
        PageInfo<CompanyHonor> companyHonorPageInfo=companyHonorService.getPageCompanyHonor(pageNum,pageSize);
        modelAndView.addObject("companyHonorPageInfo",companyHonorPageInfo);
        return modelAndView;
    }

    @RequestMapping("/main_gszl")
    public ModelAndView main_gszl(ModelAndView modelAndView) {
        modelAndView.setViewName("main_gszl");
        modelAndView.addObject("main_gszl_yyzz","img/1541741923466490.jpg");

        modelAndView.addObject("main_gszl_qyzz","img/1541746153554017.jpg");
        modelAndView.addObject("main_gszl_qyzz_others1","img/1541741923466490.jpg");
        modelAndView.addObject("main_gszl_qyzz_others2","img/1541746130320019.jpg");
        modelAndView.addObject("main_gszl_qyzz_others3","img/1541746135763425.jpg");

        modelAndView.addObject("main_gszl_ssxk","img/1541742593987250.jpg");

        modelAndView.addObject("main_gszl_wxxk_others1","img/1541742593987250.jpg");
        modelAndView.addObject("main_gszl_wxxk_others2","img/1541746130320019.jpg");
        modelAndView.addObject("main_gszl_wxxk_others3","img/1541746135763425.jpg");

        modelAndView.addObject("main_gszl_scxk","img/1541741446302114.jpg");

        return modelAndView;
    }

    @RequestMapping("/main_zzjg")
    public ModelAndView main_zzjg(ModelAndView modelAndView) {
        modelAndView.setViewName("main_zzjg");
        List<ImgBase> imgList = imgBaseService.getImgBaseListByCode("ZZJGIMG");
        modelAndView.addObject("zzjgList", imgList);
        return modelAndView;
    }

}
