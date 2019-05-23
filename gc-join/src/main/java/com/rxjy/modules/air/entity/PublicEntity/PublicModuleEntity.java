package com.rxjy.modules.air.entity.PublicEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 公共模块板块结果类
 *
 * @author yangbin
 * @date 2019-3-22
 */
@TableName("public_module")
public class PublicModuleEntity {

    /**
     * 主键
     */
    @TableId
    public  int id;

    /**
     * 模块类型
     * 培训阶段: 1、接单模块接单类型 2、培训阶段面积类型 3、培训阶段区域 4、买单
     */
    public  int moduleType;

    /**
     * 板块类型：  培训：1、业务  2、系统 3、财务
     */
    public  int plateType;

    /**
     * 子模块类型：
     *
     */
    public  int childModuleType;

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
    @TableField(exist = false)
    public  int aid;

    /**
     * 人员类型：1、空调人员
     */
    @TableField(exist = false)
    public  int userType;

    /**
     * 子模块名称
     */
    public  String childModuleName;

    public String getChildModuleName() {
        return childModuleName;
    }

    public void setChildModuleName(String childModuleName) {
        this.childModuleName = childModuleName;
    }

    public int getChildModuleType() {
        return childModuleType;
    }

    public void setChildModuleType(int childModuleType) {
        this.childModuleType = childModuleType;
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

    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }



    public int getPlateType() {
        return plateType;
    }

    public void setPlateType(int plateType) {
        this.plateType = plateType;
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
