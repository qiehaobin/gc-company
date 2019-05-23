package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 公共团队信息
 *
 * @author yangbin
 * @date 2019-3-22
 */
@TableName("public_team")
public class PublicTeamEntity {
    /**
     * 主键
     */
    @TableId
    public  int  id;

    /**
     * 人员主键
     */
    public  int aid;

    /**
     * 人员类型 1、空调人员团队
     */
    public  int userType;

    /**
     * 团队人员名称
     */
    public  String teamName;

    /**
     * 团队人员照片
     */
    public  String teamImg;

    /**
     * 团队人员类型：1、店长 2、业务
     */
    public  int teamType;

    /**
     * 是否删除 1删除 0正常
     */
    private  int delFlag;

    /**
     * 空调创建时间
     */
    private Date createDate;

    /**
     * 空调修改时间
     */
    private  Date updateDate;

    public int getTeamType() {
        return teamType;
    }

    public void setTeamType(int teamType) {
        this.teamType = teamType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamImg() {
        return teamImg;
    }

    public void setTeamImg(String teamImg) {
        this.teamImg = teamImg;
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
