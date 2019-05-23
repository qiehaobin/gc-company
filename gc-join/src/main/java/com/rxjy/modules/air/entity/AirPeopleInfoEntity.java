package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe
 *
 * @author
 * @date 2019-3-19
 */
@TableName("air_people_info")
public class AirPeopleInfoEntity {

    /**
     * 主键
     */
    @TableId
    public int attrInfoid;

    /**
     * 空调经理编号
     */
    public  int aid;

    /**
     * 照片类型编号
     * 1.空调身份证正面 2.空调身份证反面  3.空调收款凭证  4.空调紧急联系人身份证正面  5.空调紧急联系人身份证背面
     * 6.空调人员形象照  7.空调营业执照   8.空调企业资质  9.空调开户许可证 10.空调品牌授权书  11.空调法人授权书
     * 12.空调法人身份证复印件    13.空调产品质检报告             35.空调合同照片
     */
    public  int attrModelid;

    /**
     * 文件请求地址
     */
    public  String attrServerUrl;


    /**
     * 文件名称
     */
    public  String attrFileUrl;

    /**
     * 是否合格：0审核中 1合格，2不合格
     */
    public  int attrQualifiedState;

    /**
     * 合同编号
     */
    public  String uuid;

    /**
     * 是否删除 1删除 0正常
     */
    public  int delFlag;

    /**
     * 创建时间
     */
    public Date createDate;

    /**
     * 仅供删除图片使用
     */
    @TableField(exist = false)
    public  String updateAttrModelId;

    public String getUpdateAttrModelId() {
        return updateAttrModelId;
    }

    public void setUpdateAttrModelId(String updateAttrModelId) {
        this.updateAttrModelId = updateAttrModelId;
    }

    public int getAttrInfoid() {
        return attrInfoid;
    }

    public void setAttrInfoid(int attrInfoid) {
        this.attrInfoid = attrInfoid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAttrModelid() {
        return attrModelid;
    }

    public void setAttrModelid(int attrModelid) {
        this.attrModelid = attrModelid;
    }

    public String getAttrServerUrl() {
        return attrServerUrl;
    }

    public void setAttrServerUrl(String attrServerUrl) {
        this.attrServerUrl = attrServerUrl;
    }

    public String getAttrFileUrl() {
        return attrFileUrl;
    }

    public void setAttrFileUrl(String attrFileUrl) {
        this.attrFileUrl = attrFileUrl;
    }

    public int getAttrQualifiedState() {
        return attrQualifiedState;
    }

    public void setAttrQualifiedState(int attrQualifiedState) {
        this.attrQualifiedState = attrQualifiedState;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
}
