/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.entity;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 客户考察表Entity
 * @author xsk
 * @version 2019-03-15
 */
public class AirPeopleInvite implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;		//ID
	private Integer aid;		// 用户ID
	private String invitetime;		//邀约时间
	private Integer ticket;		//车票
	private String reception;		//接待人
	private Integer receptionnum;		//接待人数
	private Integer commonview;		//共识
	private Integer idea;		//理念

	public Integer getCommonview() {
		return commonview;
	}

	public void setCommonview(Integer commonview) {
		this.commonview = commonview;
	}

	public Integer getIdea() {
		return idea;
	}

	public void setIdea(Integer idea) {
		this.idea = idea;
	}

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

	public String getInvitetime() {
		return invitetime;
	}

	public void setInvitetime(String invitetime) {
		this.invitetime = invitetime;
	}

	public Integer getTicket() {
		return ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}

	public String getReception() {
		return reception;
	}

	public void setReception(String reception) {
		this.reception = reception;
	}

	public Integer getReceptionnum() {
		return receptionnum;
	}

	public void setReceptionnum(Integer receptionnum) {
		this.receptionnum = receptionnum;
	}
}