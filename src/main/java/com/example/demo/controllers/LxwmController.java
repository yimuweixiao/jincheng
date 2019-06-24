package com.example.demo.controllers;

import com.example.demo.bean.CompanyBase;
import com.example.demo.service.CompanyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LxwmController {

    @Autowired
    private CompanyBaseService companyBaseService;

    @RequestMapping("/lxwm_lxwm")
    public ModelAndView lxwm_lxwm(ModelAndView modelAndView) {
        CompanyBase companyBase=companyBaseService.getCompanyBaseByCode("MAINCOMPANY");
        modelAndView.setViewName("lxwm_lxwm");
        modelAndView.addObject("lxwm",companyBase.getAddressUrl());
        return modelAndView;
    }

    @RequestMapping("/lxwm_jrwm")
    public ModelAndView lxwm_jrwm(ModelAndView modelAndView) {
        modelAndView.setViewName("lxwm_jrwm");
        modelAndView.addObject("zhaopin","    <p><strong>\n" +
                "                            <font size=\"3\">公司常年招聘：<br></font>\n" +
                "                        </strong>1、项目经理（建造师）：大专及以上学历，工民建、给排水、电气、暖通、装饰等建筑工程类相关专业。具有一、二级建造师执业资格，注册在本公司，专兼职均可。<br>2、专业工程师（储备干部）：电气自动化、给排水、暖通专业，本科学历，熟悉办公系统软件、AUTOCAD软件，吃苦耐劳，有责任心，善于沟通。<br>3、主办会计：会计、金融相关专业，本科以上学历，熟悉建筑企业财务结算流程，熟悉相关法律法规，有责任心，细致认真，中级职称优先。&nbsp;<br>邮箱：<a\n" +
                "                                href=\"mailto:suan_group@163.com\">\n" +
                "                            <font size=\"1\">suan_group@163.com</font>\n" +
                "                        </a><br><br><strong>\n" +
                "                            <font size=\"3\">安徽分公司招聘<br></font>\n" +
                "                        </strong>项目负责人：大专以上学历，有3年以上水电，暖通，机电相关现场管理或施工经验者优先，熟悉工程项目的流程，能服从异地派遣，能吃苦耐劳，人品端正。<br>施工员：大专以上学历，水电，暖通，机电相关专业毕业，无经验要求，能服从异地派遣，能吃苦耐劳，人品端正。<br>简历请发送至：<a\n" +
                "                                href=\"mailto:szgy_ah@163.com\">szgy_ah@163.com</a><br><br><strong>\n" +
                "                            <font size=\"3\">发展空间<br></font>管理以人为本<br>\n" +
                "                        </strong>公司坚持人性化的管理思想，竭尽所能为员工提供实现自我价值的条件，为员工提供事业空间和风采展示的平台，让英雄有用武之地，让优秀人才脱颖而出。 <br><strong>企业与个人共同发展<br></strong>公司倡导员工和企业之间相互信任、理解和沟通，将员工个人的职业发展融入企业的长远发展之中，在工作中实现员工自身价值与企业价值的统一，促使员工与企业共同进步。\n" +
                "                        </p>\n" +
                "                        <p>\n" +
                "                            <font size=\"3\"><strong>福利待遇</strong><br></font><strong>薪&nbsp; 酬</strong><br>公司向员工提供具有竞争力的薪酬待遇，结合内部考核方案与激励机制，使员工绩效表现同薪酬待遇的回报紧密联系，确保优秀员工获得更多的认可与激励。<br><strong>福&nbsp;\n" +
                "                            利<br></strong>提供国家规定的社会保险（养老、医疗、失业、工伤、生育保险）和住房公积金保障。执行国家规定的公休日和法定节假日制度，并提供婚假、产假等法定休假和劳动保护，保障员工的职业健康。<br><strong>培&nbsp;\n" +
                "                            训</strong><br>人才是企业的兴盛之基，发展之本。公司注重人才的培养和团队的建设，一方面使组织内部的知识加以拓展；另一方面让员工汲取组织外部已成熟的知识，从而使员工在企业中得到进步和自身人力资本的增值。\n" +
                "                        </p>");
        return modelAndView;
    }
}
