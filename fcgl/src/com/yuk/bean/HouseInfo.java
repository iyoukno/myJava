package com.yuk.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:26
 */
public class HouseInfo {
    private int id;
    private String title;
    private String type;
    private BigDecimal price;
    private String address;
    private String hp_path;
    private int regionId;
    private int salespersonId;
    private String orientation;
    private Date time;

    public HouseInfo(String title, String type, BigDecimal price, String address, String hp_path, int regionId, int salespersonId, String orientation, Date time) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.address = address;
        this.hp_path = hp_path;
        this.regionId = regionId;
        this.salespersonId = salespersonId;
        this.orientation = orientation;
        this.time = time;
    }

    public HouseInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHp_path() {
        return hp_path;
    }

    public void setHp_path(String hp_path) {
        this.hp_path = hp_path;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(int salespersonId) {
        this.salespersonId = salespersonId;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", hp_path='" + hp_path + '\'' +
                ", regionId=" + regionId +
                ", salespersonId=" + salespersonId +
                ", orientation='" + orientation + '\'' +
                ", time=" + time +
                '}';
    }
}
