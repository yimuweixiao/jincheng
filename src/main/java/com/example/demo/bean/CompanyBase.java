package com.example.demo.bean;

public class CompanyBase {

    private String addressUrl;

    public String getAddressUrl() {
        return addressUrl;
    }

    @Override
    public String toString() {
        return "CompanyBase{" +
                "addressUrl='" + addressUrl + '\'' +
                ", imgBase=" + imgBase +
                ", introduce='" + introduce + '\'' +
                ", address='" + address + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", mobile='" + mobile + '\'' +
                ", code='" + code + '\'' +
                ", detailedIntroduce='" + detailedIntroduce + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAddressUrl(String addressUrl) {
        this.addressUrl = addressUrl;
    }

    private ImgBase imgBase;

    public ImgBase getImgBase() {
        return imgBase;
    }

    public void setImgBase(ImgBase imgBase) {
        this.imgBase = imgBase;
    }

    private String introduce;
    private String address;
    private String mailbox;
    private String mobile;
    private String code;
    private String detailedIntroduce;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getDetailedIntroduce() {
        return detailedIntroduce;
    }

    public void setDetailedIntroduce(String detailedIntroduce) {
        this.detailedIntroduce = detailedIntroduce;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
