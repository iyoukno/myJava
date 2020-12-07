package com.yuk.bean;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 9:17
 */
public class Region {
    private int id;
    private String regionName;

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
