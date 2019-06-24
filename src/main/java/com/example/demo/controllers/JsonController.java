package com.example.demo.controllers;

import com.example.demo.bean.CompanyHonor;
import com.example.demo.bean.LayuiData;
import com.example.demo.service.CompanyHonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private CompanyHonorService companyHonorService;

    @RequestMapping("/gsry")
    public LayuiData json_gsry() {
        List<CompanyHonor> list = companyHonorService.findAll();
        return new LayuiData(list);
    }
}
