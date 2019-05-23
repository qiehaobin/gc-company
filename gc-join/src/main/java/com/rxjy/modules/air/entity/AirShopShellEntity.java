package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *空调店铺店面类
 *
 *  @author yangbin
 *  @date   2019年3月12日
 */
@TableName("air_shop_shell")
public class AirShopShellEntity {

    /**
     * 空调主键 K+编号
     */
    @TableId(type = IdType.INPUT)
    private  String id;

    /**
     * 空调店铺名称
     */
    private  String shopName;

    /**
     * 店铺模板库编号
     */
    private  String shopTypeId;

    /**
     *店铺阶段：00空壳  10招  20培  30留  40用 50离
     */
    private  String shopStage;
    /**
     * 是否删除 1删除 0正常
     */
    private  String delFlag;

    /**
     * 城市编号
     */
    private  Integer cityId;


    /**
     * 空调创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String createDate;

    /**
     * 空调修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private  String updateDate;

    /**
     * 空调店铺模板名称
     */
    private  String airName;

    /**
     * 空调店铺模板数量
     */
    private  Integer shopCount;

    /**
     * 使用状态
     */
    private String useState;

    /**
     *
     */

    private Double franchiseFee;

    /**
     * 空调店铺模板店面已开数量
     */
    @TableField(exist = false)
    private  Integer openShopCount;


    /**
     * 空调店铺模板店面未开数量
     */
    @TableField(exist = false)
    private  Integer noShopCount;

    /**
     * 空调店铺模板店面信息Id
     */
    private  Integer shopInformationId;

    /**
     * 城市名称
     */
    @TableField(exist = false)
    public  String cityName;

    /**
     *店铺登录账号
     */
    public String loginCode;

    /**
     * 财务账号
     */
    public String financialAccount;

    /**
     * 财务账户*分司*分司
     */
    public  String financialAccountDivision;

    /**
     * 人员编号
     */
    @TableField(exist = false)
    public  int aid;

    /**
     * 人员姓名
     */
    @TableField(exist = false)
    public String airPeopleName;


    public String getFinancialAccountDivision() {
        return financialAccountDivision;
    }

    public void setFinancialAccountDivision(String financialAccountDivision) {
        this.financialAccountDivision = financialAccountDivision;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAirPeopleName() {
        return airPeopleName;
    }

    public void setAirPeopleName(String airPeopleName) {
        this.airPeopleName = airPeopleName;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState;
    }

    public Double getFranchiseFee() {
        return franchiseFee;
    }

    public void setFranchiseFee(Double franchiseFee) {
        this.franchiseFee = franchiseFee;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getFinancialAccount() {
        return financialAccount;
    }

    public void setFinancialAccount(String financialAccount) {
        this.financialAccount = financialAccount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getNoShopCount() {
        return noShopCount;
    }

    public void setNoShopCount(Integer noShopCount) {
        this.noShopCount = noShopCount;
    }

    public Integer getShopInformationId() {
        return shopInformationId;
    }

    public void setShopInformationId(Integer shopInformationId) {
        this.shopInformationId = shopInformationId;
    }



    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

    public Integer getShopCount() {
        return shopCount;
    }

    public void setShopCount(Integer shopCount) {
        this.shopCount = shopCount;
    }

    public Integer getOpenShopCount() {
        return openShopCount;
    }

    public void setOpenShopCount(Integer openShopCount) {
        this.openShopCount = openShopCount;
    }



    /**
     * 查询内容
     */
    @TableField(exist = false)
    private  String searchKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(String shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getShopStage() {
        return shopStage;
    }

    public void setShopStage(String shopStage) {
        this.shopStage = shopStage;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
