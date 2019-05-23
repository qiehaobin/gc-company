package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 公共子模块结果类
 *
 * @author yangbin
 * @date 2019-3-22
 */
@TableName("public_child_module")
public class PublicChildModuleEntity {

    /**
     * 主键
     */
    @TableId
    public  int id;


    /**
     * 子模块编号：
     *
     */
    public  int moduleId;

    /**
     * 子模块名称
     */
    @TableField(exist = false)
    public  String childModuleName;

    /**
     * 模块类型
     */
    @TableField(exist = false)
    public  String moduleType;

    /**
     * 模块类型名称
     */
    @TableField(exist = false)
    public  String moduleName;


    /**
     * 板块类型
     */
    @TableField(exist = false)
    public  String plateType;
    /**
     * 模块结果：1、是 2否
     */
    public  int result;

    /**
     * 是否删除 0正常 1删除
     */
    public  int delFlag;

    /**
     * 创建时间
     */
    public Date createDate;

    /**
     * 修改时间
     */
    public  Date updateDate;

    /**
     * 人员主键
     */
    public  int aid;

    /**
     * 人员类型：1、空调人员
     */
    public  int userType;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getChildModuleName() {
        return childModuleName;
    }

    public void setChildModuleName(String childModuleName) {
        this.childModuleName = childModuleName;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getPlateType() {
        return plateType;
    }

    public void setPlateType(String plateType) {
        this.plateType = plateType;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
