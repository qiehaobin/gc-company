package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.rxjy.modules.air.entity.AirPeopleInfoEntity;

import java.util.Date;
import java.util.List;

/**
 * describe 公共紧急联系人
 *
 * @author yangbin
 * @date 2019-3-22
 */
@TableName("public_emergency_user")
public class PublicEmergencyUserEntity {

    /**
     * 主键
     */
    @TableId
    public int id;

    /**
     * 紧急联系人姓名
     */
    public String userName;

    /**
     * 紧急联系人电话
     */
    public String mobile;

    /**
     * 住址
     */
    public  String address;

    /**
     * 是否删除
     */
    public int delFlag;


    /**
     * 创建时间
     */
    public Date createDate;

    /**
     * 修改时间
     */
    public  Date updateDate;

    /**
     * 人员编号
     */
    public  int aid;


    /**
     * 人员资料信息
     */
    @TableField(exist = false)
    public List<AirPeopleInfoEntity> peopleInfoEntityList;

    public List<AirPeopleInfoEntity> getPeopleInfoEntityList() {
        return peopleInfoEntityList;
    }

    public void setPeopleInfoEntityList(List<AirPeopleInfoEntity> peopleInfoEntityList) {
        this.peopleInfoEntityList = peopleInfoEntityList;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
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
