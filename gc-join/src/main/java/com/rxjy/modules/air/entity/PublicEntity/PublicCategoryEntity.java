package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 公共类别实体类
 *
 * @author yangbin
 * @date 2019--03-15
 */
@TableName("public_category")
public class PublicCategoryEntity {
    /**
     * 主键
     */
    @TableId
    public  int id;
    /**
     * 类别名称
     */
    public  String categoryName;

    /**
     *  类别类型 1、空调
     */
    public  int categoryType;



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

    /**
     * 型号数量
     */
    @TableField(exist = false)
    public  int seriesCount;
    /**
     * 产品数量
     */
    @TableField(exist = false)
    public  int productCount;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public int getSeriesCount() {
        return seriesCount;
    }

    public void setSeriesCount(int seriesCount) {
        this.seriesCount = seriesCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
