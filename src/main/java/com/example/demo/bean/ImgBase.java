package com.example.demo.bean;

public class ImgBase {
    private  String url;
    private  String name;
    private int width;
    private int height;
    private int id;
    private String code;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer heigh) {
        this.height = heigh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
