package com.yuk.bean;

import java.sql.Blob;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 8:58
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String photoPath;
    private String phone;

    public User() {
    }

    public User(String name, String password, String gender, String phone) {
        this.username = name;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", photoPath=" + photoPath +
                ", phone='" + phone + '\'' +
                '}';
    }
}
