/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.entity;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 用户咨询表Entity
 * @author xsk
 * @version 2019-03-15
 */
public class AirPeopleConsult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;		//主键ID
    private Integer aid;        //用户ID
	private Integer wxadd;		// 微信是否添加0：是1：否
	private Integer datasend;		// 资料发送，0：是1：否
	private Integer dataread;		// 资料阅读0：是1：否
	private Integer databack;		// 反馈
	private String databackinfo;		// 反馈内容

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

    public Integer getWxadd() {
		return wxadd;
	}

	public void setWxadd(Integer wxadd) {
		this.wxadd = wxadd;
	}
	
	public Integer getDatasend() {
		return datasend;
	}

	public void setDatasend(Integer datasend) {
		this.datasend = datasend;
	}
	
	public Integer getDataread() {
		return dataread;
	}

	public void setDataread(Integer dataread) {
		this.dataread = dataread;
	}
	
	public Integer getDataback() {
		return databack;
	}

	public void setDataback(Integer databack) {
		this.databack = databack;
	}
	
	@Length(min=0, max=500, message="反馈内容长度必须介于 0 和 500 之间")
	public String getDatabackinfo() {
		return databackinfo;
	}

	public void setDatabackinfo(String databackinfo) {
		this.databackinfo = databackinfo;
	}
	
}