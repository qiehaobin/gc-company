package com.rxjy.modules.air.entity.Project;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 项目信息表
 *
 * @author
 * @date 2019-3-29
 */
@TableName("project_shell")
public class ProjectShellEntity {

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 项目编号
     */
    private String projectId;

    /**
     * 店铺编号
     */
    private String shopShellId;

    /**
     * 人员编号
     */
    private Integer userId;

    /**
     * 买单状态0 买单 1未买单（默认）
     */
    private String payState;

    /**
     * 删除标识(0正常)
     */
    private String delFlag;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getShopShellId() {
        return shopShellId;
    }

    public void setShopShellId(String shopShellId) {
        this.shopShellId = shopShellId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
