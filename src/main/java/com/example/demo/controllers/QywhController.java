package com.example.demo.controllers;

import com.example.demo.bean.Achievement;
import com.example.demo.bean.ActivityDetails;
import com.example.demo.bean.CompanyActivity;
import com.example.demo.service.CompanyActivityService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QywhController {

    @Autowired
    private CompanyActivityService companyActivityService;

    @RequestMapping("/qywf_qywh")
    public ModelAndView qywf_qywh(ModelAndView modelAndView) {
        modelAndView.setViewName("qywf_qywh");
        String text="\t\t\t\t\t\t\t\t\t<strong>企业精神<br></strong>团结 尽职 开拓 求实<br><strong>企业宗旨<br></strong>科学管理 优质低耗 用户第一 信誉至上 <br><strong>企业管理方针<br></strong>追求卓越品质\n" +
                "\t\t\t\t\t\t\t\t\t关爱生存环境 保障健康安全 持续苏安辉煌 <br><strong>企业价值观<br></strong>团队精神 主人翁精神 尊重人 积极主动 求实 创新<br><strong><br><br>\n" +
                "\t\t\t\t\t\t\t\t\t\t<font size=\"3\">团结</font>\n" +
                "\t\t\t\t\t\t\t\t\t</strong>是企业发展的根本，是成功的基石。《孙子•谋攻》中有云“上下同欲者胜”，一个企业要在市场经济的浪潮中乘风破浪、勇往直前，就需要领导与员工上下齐心、目标一致，这样的企业动则如千矢一的不可阻挡，静则似磐石般坚不可摧。<br><br><strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t<font size=\"3\">尽职</font>\n" +
                "\t\t\t\t\t\t\t\t\t</strong>是管理制度实施的保障。员工不尽职，管理就会松散，制度就会成为空谈。成熟的企业懂得如何将每个职员都紧紧的凝聚在一起，激发每个人的热情为企业的利益而努力，从而使企业取得最大利益。<br><br><strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t<font size=\"3\">开拓</font>\n" +
                "\t\t\t\t\t\t\t\t\t</strong>是企业长盛不衰的源动力。苏安集团历经半个世纪的风雨，依然永葆青春的秘诀不仅在于苏安人高瞻远瞩的眼界与勇于开拓市场的气魄，也在于公司始终将改革创新作为企业价值观贯彻如一。<br><br><strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t<font size=\"3\">求实</font>\n" +
                "\t\t\t\t\t\t\t\t\t</strong>是企业健康稳定的后盾。秉承着“精益求精、追求卓越”的态度，苏安集团一贯将打造优质工程、持续提高客户满意度作为奋斗目标，坚持用事实说话，以品质赢得信誉。在全体员工的辛勤努力下，公司历年来屡获殊荣，专业技术水平持续走在行业的前列。<br>";
        modelAndView.addObject("qywhText",text);
        return modelAndView;
    }

    @RequestMapping("/qywf_gshd")
    public ModelAndView qywf_gshd(ModelAndView modelAndView, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize) {
        modelAndView.setViewName("qywf_gshd");
        PageInfo<CompanyActivity> activityPageInfo=companyActivityService.getCompanyActivityList(pageNum,pageSize);
        modelAndView.addObject("activityPageInfo",activityPageInfo);
        return modelAndView;
    }

    @RequestMapping("/qywfDetails")
    public ModelAndView qywfDetails(ModelAndView modelAndView, @RequestParam("id") Integer activityId) {
        modelAndView.setViewName("qywf_gshd_details");
        CompanyActivity companyActivity=companyActivityService.getActivityById(activityId);
        modelAndView.addObject("companyActivity",companyActivity);
        List<ActivityDetails> list=companyActivityService.getActivityDetailById(activityId);
        modelAndView.addObject("detailsList",list);
        return modelAndView;
    }
}
