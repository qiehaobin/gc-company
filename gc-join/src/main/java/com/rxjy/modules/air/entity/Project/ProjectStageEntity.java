package com.rxjy.modules.air.entity.Project;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;
import java.util.List;
/**
 * describe 项目阶段信息表
 *
 * @author
 * @date 2019-3-29
 */
@TableName("project_stage")
public class ProjectStageEntity {
    /**
     * 主键
     */
    @TableId
    private int id;

    /**
     * 项目阶段名称
     */
    private String projectStageName;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectStageName() {
        return projectStageName;
    }

    public void setProjectStageName(String projectStageName) {
        this.projectStageName = projectStageName;
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
