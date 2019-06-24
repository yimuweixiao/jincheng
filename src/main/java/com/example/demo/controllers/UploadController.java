package com.example.demo.controllers;

import com.example.demo.bean.ImgBase;
import com.example.demo.service.ImgBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${web.upload-path}")
    String uploadPath;


    @Autowired
    private ImgBaseService imgBaseService;


    @RequestMapping("/indexWheel/add")
    @ResponseBody
    public HashMap indexUpload(@RequestParam("file") MultipartFile[] files) {
        HashMap map = new HashMap();
        map.put("success", false);
        if (files == null || files.length == 0) {
            return map;
        }
        for (MultipartFile file : files) {
            // TODO Spring Mvc 提供的写入方式
            try {
                file.transferTo(new File(uploadPath + file.getOriginalFilename()));
                String dbUrl = "/img/" + file.getOriginalFilename();
                //存数据库
                ImgBase imgBase = new ImgBase();
                imgBase.setUrl(dbUrl);
                imgBase.setName("首页轮播图");
                imgBase.setCode("INDEXWHEEL");
                imgBase.setHeight(390);
                imgBase.setWidth(1062);
                imgBaseService.insert(imgBase);
            } catch (IOException e) {
                e.printStackTrace();
                return map;
            }

        }
        map.put("success", true);
        return map;
    }


    @RequestMapping("/indexWheel/delete")
    @ResponseBody
    public HashMap indexDelete(@RequestParam("id") Integer id) {
        HashMap map = new HashMap();
        imgBaseService.delete(id);
        map.put("success", true);
        return map;
    }


    @RequestMapping("/secWheel/add")
    @ResponseBody
    public HashMap secUpload(@RequestParam("file") MultipartFile[] files) {
        HashMap map = new HashMap();
        map.put("success", false);
        if (files == null || files.length == 0) {
            return map;
        }
        for (MultipartFile file : files) {
            // TODO Spring Mvc 提供的写入方式
            try {
                file.transferTo(new File(uploadPath + file.getOriginalFilename()));
                String dbUrl = "/img/" + file.getOriginalFilename();
                //存数据库
                ImgBase imgBase = new ImgBase();
                imgBase.setUrl(dbUrl);
                imgBase.setName("次页轮播图");
                imgBase.setCode("XTWHEEL");
                imgBase.setHeight(220);
                imgBase.setWidth(1062);
                imgBaseService.insert(imgBase);
            } catch (IOException e) {
                e.printStackTrace();
                return map;
            }

        }
        map.put("success", true);
        return map;
    }

    @RequestMapping("/companyImg")
    @ResponseBody
    public HashMap secUpload(@RequestParam("file") MultipartFile file) {
        HashMap map = new HashMap();
        map.put("success", false);
        if (file == null) {
            return map;
        }
        try {
            file.transferTo(new File(uploadPath + file.getOriginalFilename()));
            String dbUrl = "/img/" + file.getOriginalFilename();
            //存数据库
            ImgBase imgBase = new ImgBase();
            imgBase.setUrl(dbUrl);
            imgBase.setId(1);
            imgBase.setName("公司照片");
            imgBase.setCode("COMPANYIMG");
            imgBase.setHeight(150);
            imgBase.setWidth(174);
            imgBaseService.update(imgBase);
        } catch (IOException e) {
            e.printStackTrace();
            return map;
        }
        map.put("success", true);
        return map;
    }
}
