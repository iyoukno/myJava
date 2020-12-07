package com.yuk.bean;

import java.sql.Date;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/12/1 15:50
 */
public class ApplyShow {
    private int id;
    private String userName;
    private String houseName;
    private Date date;
    private int status;

    public ApplyShow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplyShow{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", houseName='" + houseName + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
