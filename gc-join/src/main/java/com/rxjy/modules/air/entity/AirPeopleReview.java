/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户考察表Entity
 * @author xsk
 * @version 2019-03-15
 */
public class AirPeopleReview implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;		//ID
	private Integer aid;		// 用户ID
	private Integer othercomparyid;		// 分司城市id
	private String othercomparyname;		// 分司名称
	private String reviewtime;		// 考察时间
	private String customerinfo;		// 客户评价内容
	private Integer customerassess;		// 客户评价，优良中差
	private String othercomparyinfo;		// 分司评价内容
	private Integer othercomparyassess;		// 分司评价，优良中差

    private Integer updateType;     //修改类型

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	public Integer getOthercomparyid() {
		return othercomparyid;
	}

	public void setOthercomparyid(Integer othercomparyid) {
		this.othercomparyid = othercomparyid;
	}
	
	@Length(min=0, max=50, message="分司名称长度必须介于 0 和 50 之间")
	public String getOthercomparyname() {
		return othercomparyname;
	}

	public void setOthercomparyname(String othercomparyname) {
		this.othercomparyname = othercomparyname;
	}

    public String getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(String reviewtime) {
        this.reviewtime = reviewtime;
    }

    @Length(min=0, max=2000, message="客户评价内容长度必须介于 0 和 2000 之间")
	public String getCustomerinfo() {
		return customerinfo;
	}

	public void setCustomerinfo(String customerinfo) {
		this.customerinfo = customerinfo;
	}
	
	public Integer getCustomerassess() {
		return customerassess;
	}

	public void setCustomerassess(Integer customerassess) {
		this.customerassess = customerassess;
	}
	
	@Length(min=0, max=2000, message="分司评价内容长度必须介于 0 和 2000 之间")
	public String getOthercomparyinfo() {
		return othercomparyinfo;
	}

	public void setOthercomparyinfo(String othercomparyinfo) {
		this.othercomparyinfo = othercomparyinfo;
	}
	
	public Integer getOthercomparyassess() {
		return othercomparyassess;
	}

	public void setOthercomparyassess(Integer othercomparyassess) {
		this.othercomparyassess = othercomparyassess;
	}
	
}