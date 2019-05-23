package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 店铺壳表 
 * 
 * @author lulu_dong
 * @email luludong@rxjy.com
 * @date 2019-03-11 17:48:14
 */
@TableName("tcp_shop_shell")
public class TcpShopShellEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键店铺壳编号名称首字母大写 - 加三位流水号（001-999）空调 KT-001、家居 JJ-001、消防 XF-001、弱电 RD-001、设计院 SJ-001
	 */
	@TableId
	private String id;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 店铺类型
	 */
	private String shopTypeId;
	/**
	 * 店铺阶段00空壳 10招 20培 30留 40用 50离
	 */
	private String shopStage;
	/**
	 * 店铺信息编号
	 */
	private Integer shopInformationId;
	/**
	 * 城市编号
	 */
	private Integer cityId;

	/**
	 * 店铺阶段00空壳 10招 20培 30留 40用 50离
	 */
	@TableField(exist = false)
	private String shopStages;
	/**
	 * 店铺数量
	 */
	@TableField(exist = false)
	private Integer shopNum;
	/**
	 * 店铺类型名称
	 */
	@TableField(exist = false)
	private String shopTypeName;
	/**
	 * 城市名称
	 */
	@TableField(exist = false)
	private String cityName;
	/**
	 * 店铺类别1 空调、2家居、3消防、4弱电、5设计院
	 */
	@TableField(exist = false)
	private String shopCategory;
	/**
	 * 店铺类别1 空调、2家居、3消防、4弱电、5设计院
	 */
	@TableField(exist = false)
	private String shopCategorys;

	/**
	 * 店铺类别名称1 空调、2家居、3消防、4弱电、5设计院
	 */
	@TableField(exist = false)
	private String shopCategoryName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShopCategorys() {
		return shopCategorys;
	}

	public void setShopCategorys(String shopCategorys) {
		this.shopCategorys = shopCategorys;
	}

	public String getShopStages() {
		return shopStages;
	}

	public void setShopStages(String shopStages) {
		this.shopStages = shopStages;
	}

	public Integer getShopNum() {
		return shopNum;
	}

	public void setShopNum(Integer shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getShopTypeName() {
		return shopTypeName;
	}

	public void setShopTypeName(String shopTypeName) {
		this.shopTypeName = shopTypeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	/**
	 * 设置：店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：店铺类型
	 */
	public void setShopTypeId(String shopTypeId) {
		this.shopTypeId = shopTypeId;
	}
	/**
	 * 获取：店铺类型
	 */
	public String getShopTypeId() {
		return shopTypeId;
	}
	/**
	 * 设置：店铺阶段00空壳 10招 20培 30留 40用 50离
	 */
	public void setShopStage(String shopStage) {
		this.shopStage = shopStage;
	}
	/**
	 * 获取：店铺阶段00空壳 10招 20培 30留 40用 50离
	 */
	public String getShopStage() {
		return shopStage;
	}
	/**
	 * 设置：店铺信息编号
	 */
	public void setShopInformationId(Integer shopInformationId) {
		this.shopInformationId = shopInformationId;
	}
	/**
	 * 获取：店铺信息编号
	 */
	public Integer getShopInformationId() {
		return shopInformationId;
	}
	/**
	 * 设置：城市编号
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：城市编号
	 */
	public Integer getCityId() {
		return cityId;
	}
}
