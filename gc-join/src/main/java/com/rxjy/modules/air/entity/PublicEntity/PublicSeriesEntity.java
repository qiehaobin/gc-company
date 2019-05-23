package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 公共系列实体类
 *
 * @author yangbin
 * @date 2019--03-15
 */
@TableName("public_series")
public class PublicSeriesEntity {
    /**
     * 主键
     */
    @TableId
    public  int id;
    /**
     * 系列名称
     */
    public  String seriesName;

    /**
     *  系列类型 1、空调
     */
    public  int seriesType;

    /**
     * 类型编号
     */
    public  int categoryTypeId;



    /**
     * 是否删除 0正常 1删除
     */
    public  String delFlag;

    /**
     * 创建时间
     */
    public Date createTime;
    /**
     * 更新时间
     */
    public  Date updateTime;

    /**
     * 类别名称
     */
    public  String categoryName;

    /**
     * 产品数量
     */
    @TableField(exist = false)
    public  int productCount;

    /**
     * 在空调商户商品表中的记录条数
     */
    @TableField(exist = false)
    private int isChecked;

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(int seriesType) {
        this.seriesType = seriesType;
    }

    public int getCategoryTypeId() {
        return categoryTypeId;
    }

    public void setCategoryTypeId(int categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
