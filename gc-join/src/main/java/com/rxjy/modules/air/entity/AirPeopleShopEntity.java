package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;
import java.util.List;

/**
 * describe 空调人员店铺信息
 *
 * @author
 * @date 2019-3-20
 */
@TableName("air_people_shop")
public class AirPeopleShopEntity {
    /**
     * 主键
     */
    @TableId
    public  int id;

    /**
     * 店铺模板编号
     */
    public  String shopId;

    /**
     * 类型编号
     */
    public  String shellId;

    /**
     * 公司名称
     */
    public  String companyName;

    /**
     * 法人/股东姓名
     */
    public String legalName;

    /**
     * 办公住址
     */
    public String officeSpace;

    /**
     * 创建时间
     */
    public Date createDate;

    /**
     * 人员编号
     */
    public  int aid;

    /**
     * 空调名称
     */
    @TableField(exist = false)
    public  String airName;

    /**
     * 省编号
     */
    public  String provinceId;

    /**
     * 省名称
     */
    public  String provinceName;

    /**
     * 市编号
     */
    public  String cityId;

    /**
     * 市编号
     */
    public  String cityName;

    /**
     * 区地址
     */
    public  String areaName;

    /**
     * 街道地址
     */
    public  String street;

    /**
     * 详细地址
     */
    public  String address;
    /**
     * 资料信息
     */
    @TableField(exist = false)
    public List<AirPeopleInfoEntity> airPeopleInfoEntityList;



    /**
     * 城市编号
     */
    @TableField(exist = false)
    public  int cityCode;

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public List<AirPeopleInfoEntity> getAirPeopleInfoEntityList() {
        return airPeopleInfoEntityList;
    }

    public void setAirPeopleInfoEntityList(List<AirPeopleInfoEntity> airPeopleInfoEntityList) {
        this.airPeopleInfoEntityList = airPeopleInfoEntityList;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShellId() {
        return shellId;
    }

    public void setShellId(String shellId) {
        this.shellId = shellId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getOfficeSpace() {
        return officeSpace;
    }

    public void setOfficeSpace(String officeSpace) {
        this.officeSpace = officeSpace;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
