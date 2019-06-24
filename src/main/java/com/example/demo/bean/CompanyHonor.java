package com.example.demo.bean;

public class CompanyHonor {
    private int id;
    private String time;
    private String honor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    @Override
    public String toString() {
        return "CompanyHonor{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", honor='" + honor + '\'' +
                '}';
    }
}
