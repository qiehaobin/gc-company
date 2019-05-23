package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * 空调类别商品表
 */
@TableName("air_shop_product")
public class AirShopProductEntity {

    /**
     * 表id
     */
    @TableId
    private Integer id;

    /**
     * 商品id  对应shop_id
     */
    private String shopId;

    /**
     * 类别id对应 category_id
     */
    private Integer categoryId;

    /**
     * 型号参数id   series_id
     */
    private Integer seriesId;

    /**
     * 商品id  product_id
     */
    private Integer productId;

    /**
     * 创建时间
     * @return
     */
    private Date createDate;

    /**
     * 修改时间
     * @return
     */
    private Date updateDate;

    /**
     * 数据的状态
     * 0 数据正常态  1数据删除态
     * @return
     */
    private Integer delFlag;

    /**
     * 类别名称
     */
    @TableField(exist = false)
    private  String categoryName;

    /**
     * 系列名称
     */
    @TableField(exist = false)
    private  String seriesName;


    /**
     * 产品名称
     */
    @TableField(exist = false)
    private  String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }




    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
