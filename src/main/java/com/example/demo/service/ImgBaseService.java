package com.example.demo.service;

import com.example.demo.bean.ImgBase;
import com.example.demo.dao.ImgBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImgBaseService {
    @Autowired
    private ImgBaseDao imgBaseDao;

    public ImgBase getImgBaseById(int id){
        return imgBaseDao.getImgBaseById(id);
    }

    public  ImgBase getImgBaseByCode(String code){
        return imgBaseDao.getImgBaseByCode(code);
    }

    public List<ImgBase> getImgBaseListByCode(String code){return  imgBaseDao.getImgBaseListByCode(code);}

    public int insert(ImgBase imgBase){
        return imgBaseDao.insert(imgBase);
    }

    public int delete(int id){
        return imgBaseDao.delete(id);
    }


    public int update(ImgBase imgBase){
        return imgBaseDao.update(imgBase);
    }

}
