package com.example.demo.bean;

import java.util.List;

public class LayuiData {
    private Integer count;
    private Integer code;
    private String msg;
    private List data;

    public LayuiData(List data) {
        this.code=0;
        this.count=data.size();
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}