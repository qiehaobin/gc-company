package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.sun.tracing.dtrace.ModuleName;

import java.util.Date;

/**
 *空调店铺类
 *
 *  @author yangbin
 *  @date   2019年3月12日
 */
@TableName("air_shop")
public class AirShopEntity {

    /**
     * 空调主键 K+编号
     */
    @TableId(type = IdType.INPUT)
    private  String id;

    /**
     * 空调名称
     */
    private  String airName;

    /**
     * 是否删除 1删除 0正常
     */
    private  String delFlag;

    /**
     * 空调创建时间
     */
    private Date createDate;

    /**
     * 空调修改时间
     */
    private  Date updateDate;

    /**
     * 查询内容
     */
    @TableField(exist = false)
    private  String searchKey;
    /**
     * 提交类型：1、本系统提交 2、六师提交
     */
    @TableField(exist = false)
    private  Integer submitType;

    /**
     * 产品编号
     */
    @TableField(exist = false)
    private  int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getSubmitType() {
        return submitType;
    }

    public void setSubmitType(Integer submitType) {
        this.submitType = submitType;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
