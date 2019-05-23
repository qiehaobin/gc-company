package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe
 *
 * @author
 * @date 2019-3-16
 */
@TableName("public_product")
public class PublicProductEntity {
    /**
     * 主键
     */
    @TableId
    public   int id;

    /**
     * 产品名称
     */
    public  String productName;

    /**
     * 类别编号
     */
    public  Integer   categoryId;

    /**
     * 类别名称
     */
    public  String   categoryName;

    /**
     * 型号编号
     */
    public  Integer   seriesId;


    /**
     * 型号名称
     */
    public  String   seriesName;

    /**
     * 单位
     */
    public  String   unit;

    /**
     * 金额
     */
    public  Double   price;

    /**
     * 主图
     */
    public  String   mainImg;

    /**
     * 备注
     */
    public  String remark;

    /**
     * 产品类型：1、空调产品
     */
    public  int productType;

    /**
     * 是否删除 1删除 0正常
     */
    public  String delFlag;

    /**
     * 创建时间
     */
    public Date createTime;

    /**
     * 修改时间
     */
    public Date updateTime;

    /**
     * 品牌名称
     */
    @TableField(exist = false)
    public  String airName;

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

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

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
