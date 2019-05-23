package com.rxjy.modules.air.entity;

import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicChildModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicTeamEntity;

import java.util.List;

/**
 *空调店铺类
 *
 *  @author yangbin
 *  @date   2019年3月12日
 */
public class AirShopListDTO {

    /**
     * 店铺编号
     */
    public  String shopId;
    /**
     *  凭证号
     */
    public  String sourceCode;

    /**
     * 加盟金额
     */
    public  double joinMoney;

    /**
     * 金额类型  1、加盟费 2风险金
     */
    public  Integer moneyType;

    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public double getJoinMoney() {
        return joinMoney;
    }

    public void setJoinMoney(double joinMoney) {
        this.joinMoney = joinMoney;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * 空调店铺店壳接收类
     */
    private List<AirShopShellEntity>  jsonStr;

    public List<AirShopShellEntity> getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(List<AirShopShellEntity> jsonStr) {
        this.jsonStr = jsonStr;
    }


    /**
     * 公共类型信息接收类
     */
    private List<PublicCategoryEntity>  publicCategoryEntities;

    public List<PublicCategoryEntity> getPublicCategoryEntities() {
        return publicCategoryEntities;
    }

    public void setPublicCategoryEntities(List<PublicCategoryEntity> publicCategoryEntities) {
        this.publicCategoryEntities = publicCategoryEntities;
    }

    /**
     * 公共型号信息接收类
     */

    private  List<PublicSeriesEntity> publicSeriesEntities;

    public List<PublicSeriesEntity> getPublicSeriesEntities() {
        return publicSeriesEntities;
    }

    public void setPublicSeriesEntities(List<PublicSeriesEntity> publicSeriesEntities) {
        this.publicSeriesEntities = publicSeriesEntities;
    }

    /**
     * 空调人员信息
     */
    public  AirPeopleEntity airPeopleEntity;

    /**
     * 空调人员图片信息
     */
    public  List<AirPeopleInfoEntity> airPeopleInfoEntities;

    public AirPeopleEntity getAirPeopleEntity() {
        return airPeopleEntity;
    }

    public void setAirPeopleEntity(AirPeopleEntity airPeopleEntity) {
        this.airPeopleEntity = airPeopleEntity;
    }

    public List<AirPeopleInfoEntity> getAirPeopleInfoEntities() {
        return airPeopleInfoEntities;
    }

    public void setAirPeopleInfoEntities(List<AirPeopleInfoEntity> airPeopleInfoEntities) {
        this.airPeopleInfoEntities = airPeopleInfoEntities;
    }

    /**
     * 公共模块状态信息
     */
    public  List<PublicChildModuleEntity> publicChildModuleEntities;

    public List<PublicChildModuleEntity> getPublicChildModuleEntities() {
        return publicChildModuleEntities;
    }

    public void setPublicChildModuleEntities(List<PublicChildModuleEntity> publicChildModuleEntities) {
        this.publicChildModuleEntities = publicChildModuleEntities;
    }


    /**
     * 公共团队信息
     */
    public  List<PublicTeamEntity> publicTeamEntities;

    public List<PublicTeamEntity> getPublicTeamEntities() {
        return publicTeamEntities;
    }

    public void setPublicTeamEntities(List<PublicTeamEntity> publicTeamEntities) {
        this.publicTeamEntities = publicTeamEntities;
    }

    /**
     * AirShopProductEntity空调商店商品信息
     */
    private List<AirShopProductEntity>  airShopProductEntitis;

    public List<AirShopProductEntity> getAirShopProductEntitis() {
        return airShopProductEntitis;
    }

    public void setAirShopProductEntitis(List<AirShopProductEntity> airShopProductEntitis) {
        this.airShopProductEntitis = airShopProductEntitis;
    }


}
