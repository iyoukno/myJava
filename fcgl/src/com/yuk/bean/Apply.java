package com.yuk.bean;

import java.sql.Date;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:13
 */
public class Apply {
    private int id;
    private int userId;
    private int houseId;
    private Date date;
    private int status;

    public Apply() {
    }

    public Apply(int userId, int houseId, Date date, int status) {
        this.userId = userId;
        this.houseId = houseId;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
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
        return "Apply{" +
                "id=" + id +
                ", userId=" + userId +
                ", houseId=" + houseId +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
