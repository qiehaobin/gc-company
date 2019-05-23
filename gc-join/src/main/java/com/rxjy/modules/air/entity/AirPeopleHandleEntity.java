package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *  空调经理评价
 *
 *  @author 任何
 *  @date   2019年3月14日
 */
@TableName("air_people_handle")
public class AirPeopleHandleEntity {

    /**
     * 空调经理评价主键
     */
    @TableId
    private  Integer id;
    /**
     * air_people主键(空调经理表)
     */
    private  Integer aid;
    /**
     * 处理状态 1招聘 2咨询 3考察 4邀约 5集团 6签约 7淘汰
     */
    private  Integer airPeopleStage;
    /**
     * 处理内容
     */
    private  String content;
    /**
     * 是否删除 0正常 1删除
     */
    private  Integer delFlag;

    /**
     *
     */
    private  String createNo;
    /**
     *
     */
    private  String createUser;
    /**
     *
     */
    private  String createDate;

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

    public Integer getAirPeopleStage() {
        return airPeopleStage;
    }

    public void setAirPeopleStage(Integer airPeopleStage) {
        this.airPeopleStage = airPeopleStage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateNo() {
        return createNo;
    }

    public void setCreateNo(String createNo) {
        this.createNo = createNo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
