package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 店铺类型表 
 * 
 * @author lulu_dong
 * @email luludong@rxjy.com
 * @date 2019-03-11 17:48:14
 */
@TableName("tcp_shop_type")
public class TcpShopTypeEntity {
	private static final long serialVersionUID = 1L;

	public TcpShopTypeEntity() {
	}

	public TcpShopTypeEntity(String shopTypeName) {
		this.shopTypeName = shopTypeName;
	}

	/**
	 * 主键店铺类型编号名称首字母大写 - 加两位流水号（01-99）空调 K-01、家居 J-01、消防 X-01、弱电 R-01、设计院 S-01
	 */
	@TableId
	private String id;
	/**
	 * 店铺类型名称
	 */
	private String shopTypeName;
	/**
	 * 店铺类别1 空调、2家居、3消防、4弱电、5设计院
	 */
	private String shopCategory;

	/**
	 * 是否删除 1删除 0正常
	 */
	private  String delFlag;
	/**
	 * 城市编号
	 */
	@TableField(exist = false)
	private Integer cityId;
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

	/**
	 * 店铺空壳数量
	 */
	@TableField(exist = false)
	private Integer shellNullCount;

	/**
	 * 店铺所有店壳数量
	 */
	@TableField(exist = false)
	private Integer shellAllCount;

	/**
	 * 店铺使用数量
	 */
	@TableField(exist = false)
	private Integer shellUseCount;

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getShopCategorys() {
		return shopCategorys;
	}

	public void setShopCategorys(String shopCategorys) {
		this.shopCategorys = shopCategorys;
	}

	public Integer getShellNullCount() {
		return shellNullCount;
	}

	public void setShellNullCount(Integer shellNullCount) {
		this.shellNullCount = shellNullCount;
	}

	public Integer getShellAllCount() {
		return shellAllCount;
	}

	public void setShellAllCount(Integer shellAllCount) {
		this.shellAllCount = shellAllCount;
	}

	public Integer getShellUseCount() {
		return shellUseCount;
	}

	public void setShellUseCount(Integer shellUseCount) {
		this.shellUseCount = shellUseCount;
	}

	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	/**
	 * 设置：店铺类型名称
	 */
	public void setShopTypeName(String shopTypeName) {
		this.shopTypeName = shopTypeName;
	}
	/**
	 * 获取：店铺类型名称
	 */
	public String getShopTypeName() {
		return shopTypeName;
	}
	/**
	 * 设置：店铺类别1 空调、2家居、3消防、4弱电、5设计院
	 */
	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}
	/**
	 * 获取：店铺类别1 空调、2家居、3消防、4弱电、5设计院
	 */
	public String getShopCategory() {
		return shopCategory;
	}
}
