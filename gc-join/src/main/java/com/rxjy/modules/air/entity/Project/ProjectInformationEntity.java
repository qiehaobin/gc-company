package com.rxjy.modules.air.entity.Project;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * describe 项目信息表
 *
 * @author
 * @date 2019-3-29
 */
@TableName("project_information")
public class ProjectInformationEntity {
    /**
     * 编号
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 项目单号
     */
    private String projectNumber;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 地区编号
     */
    private Integer regionId;

    /**
     * 项目阶段编号
     */
    private Integer projectStageId;

    /**
     * 是否删除 1删除 0正常
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 合同编号
     */
    private String contractNumber;

    /**
     * 项目地址
     */
    private String projectAddress;

    /**
     * 工期
     */
    private Integer durationExtension;

    /**
     * 工期倒计时
     */
    private Integer countDown;

    /**
     * 实际施工用时
     */
    private Integer actualCompletionTime;

    /**
     * 延期
     */
    private Integer delay;

    /**
     * 企业性质
     */
    private String natureOfEnterprise;

    /**
     * 项目属性
     */
    private String itemAttribute;

    /**
     * 项目面积
     */
    private double areaage;

    /**
     * 项目级别
     */
    private String levelName;

    /**
     * 项目买单金额
     */
    private double levelMoney;

    /**
     * 项目分数
     */
    private Integer detailScore;

    /**
     * 人员编号
     */
    @TableField(exist =  false)
    private  int userId;
    /**\
     * 买单状态
     */
    @TableField(exist = false)
    private  int payState;
    /**
     * 地区名称
     */
    @TableField(exist = false)
    public  String regionName;

    /**
     * 店壳编号
     */
    @TableField(exist = false)
    public String shopShellId;

    public String getShopShellId() {
        return shopShellId;
    }

    public void setShopShellId(String shopShellId) {
        this.shopShellId = shopShellId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getProjectStageId() {
        return projectStageId;
    }

    public void setProjectStageId(Integer projectStageId) {
        this.projectStageId = projectStageId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public Integer getDurationExtension() {
        return durationExtension;
    }

    public void setDurationExtension(Integer durationExtension) {
        this.durationExtension = durationExtension;
    }

    public Integer getCountDown() {
        return countDown;
    }

    public void setCountDown(Integer countDown) {
        this.countDown = countDown;
    }

    public Integer getActualCompletionTime() {
        return actualCompletionTime;
    }

    public void setActualCompletionTime(Integer actualCompletionTime) {
        this.actualCompletionTime = actualCompletionTime;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getNatureOfEnterprise() {
        return natureOfEnterprise;
    }

    public void setNatureOfEnterprise(String natureOfEnterprise) {
        this.natureOfEnterprise = natureOfEnterprise;
    }

    public String getItemAttribute() {
        return itemAttribute;
    }

    public void setItemAttribute(String itemAttribute) {
        this.itemAttribute = itemAttribute;
    }

    public double getAreaage() {
        return areaage;
    }

    public void setAreaage(double areaage) {
        this.areaage = areaage;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public double getLevelMoney() {
        return levelMoney;
    }

    public void setLevelMoney(double levelMoney) {
        this.levelMoney = levelMoney;
    }

    public Integer getDetailScore() {
        return detailScore;
    }

    public void setDetailScore(Integer detailScore) {
        this.detailScore = detailScore;
    }
}
