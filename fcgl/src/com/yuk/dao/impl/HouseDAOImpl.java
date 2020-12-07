package com.yuk.dao.impl;

import com.yuk.bean.HouseInfo;
import com.yuk.dao.BaseDAO;
import com.yuk.dao.HouseDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/27 11:11
 */
public class HouseDAOImpl extends BaseDAO<HouseInfo> implements HouseDAO {
    @Override
    public List<HouseInfo> queryAllHouse(Connection con) {
        String sql="select id,title,type,price,address,hp_path,region_id regionId,salesperson_id salespersonId,orientation,time from t_houseinfo";
        List<HouseInfo> houseList = getInstances(con, sql);
        return houseList;
    }

    @Override
    public int deleteHouseInfoById(Connection con,int id) {
        String sql="delete from t_houseinfo where id = ?";
        update(con,sql,id);
        return 1;
    }

    @Override
    public List<HouseInfo> QueryHouseByType(Connection con, String Type,int begin,int count) {
        String t="%"+Type+"%";
        String sql="select id,title,type,price,address,hp_path,region_id regionId,salesperson_id salespersonId,orientation,time from t_houseinfo where type like ? limit ?,?";
        List<HouseInfo> infoList = getInstances(con, sql, t,begin,count);
        return infoList;
    }

    @Override
    public List<HouseInfo> QueryHouseByPrice(Connection con, BigDecimal price,int begin,int count) {
        String sql="select id,title,type,price,address,hp_path,region_id regionId,salesperson_id salespersonId,orientation,time from t_houseinfo where price <= ? limit ?,?";
        List<HouseInfo> infoList = getInstances(con, sql, price,begin,count);
        return infoList;
    }

    @Override
    public List<HouseInfo> QueryHouseByRegion(Connection con, String region,int begin,int count) {
        String t="%"+region+"%";
        String sql="SELECT th.id,th.title,th.type,th.price,th.address,th.hp_path,th.region_id regionId,th.salesperson_id salespersonId,orientation,th.time\n" +
                "              from  t_region tr RIGHT JOIN t_houseinfo th ON tr.id = th.region_id where tr.region_name like ? limit ?,?";
        List<HouseInfo> instances = getInstances(con, sql,t,begin,count);
        return instances;
    }

    @Override
    public List<HouseInfo> queryHouseByPage(Connection con, int begin, int count) {
        String sql="select id,title,type,price,address,hp_path,region_id regionId,salesperson_id salespersonId,orientation,time " +
                "from t_houseinfo limit ?,?";
        List<HouseInfo> instances = getInstances(con, sql, begin, count);
        return instances;
    }

    @Override
    public void addAHouseInfo(Connection con, HouseInfo houseInfo) {
        String sql="insert into t_houseinfo" +
                "(title,type,price,address,hp_path,region_id,salesperson_id,orientation,time)"+
                "value(?,?,?,?,?,?,?,?,?)";
        update(con,sql,houseInfo.getTitle(),houseInfo.getType(),houseInfo.getPrice(),
                houseInfo.getHp_path(),houseInfo.getRegionId(),houseInfo.getSalespersonId(),
                houseInfo.getOrientation(),new Date(System.currentTimeMillis()));
    }


}
