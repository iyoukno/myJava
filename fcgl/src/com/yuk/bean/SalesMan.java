package com.yuk.bean;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:19
 */
public class SalesMan {
    private int id;
    private String name;
    private String gender;
    private String tel;

    public SalesMan() {
    }

    public SalesMan(String name, String gender, String tel) {
        this.name = name;
        this.gender = gender;
        this.tel = tel;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "SalesMan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
