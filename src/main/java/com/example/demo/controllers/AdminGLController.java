package com.example.demo.controllers;

import com.example.demo.bean.CompanyBase;
import com.example.demo.bean.CompanyHonor;
import com.example.demo.service.CompanyBaseService;
import com.example.demo.service.CompanyHonorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gl")
public class AdminGLController {

    @Autowired
    private CompanyBaseService companyBaseService;

    @Autowired
    private CompanyHonorService companyHonorService;

    @RequestMapping("/gsjj")
    @ResponseBody
    public boolean gl_gsjj(@RequestBody CompanyBase companyBase) {
        boolean success = true;
        companyBase.setId(1);
        companyBaseService.update(companyBase);
        return success;
    }

    @RequestMapping("/gsry/update")
    @ResponseBody
    public void gl_gsry_update(@RequestBody CompanyHonor companyHonor) {
        companyHonorService.update(companyHonor);
    }

    @RequestMapping("/gsry/del")
    @ResponseBody
    public void gl_gsry_del(@RequestParam("id") Integer id){
        companyHonorService.delete(id);
    }

    @RequestMapping("/gsry/add")
    @ResponseBody
    public void gl_gsry_add(@RequestBody CompanyHonor companyHonor) {
        companyHonorService.insert(companyHonor);
    }
}
