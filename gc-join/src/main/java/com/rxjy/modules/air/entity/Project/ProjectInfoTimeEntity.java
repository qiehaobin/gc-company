package com.rxjy.modules.air.entity.Project;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * describe 项目信息时间表
 *
 * @author
 * @date 2019-3-29
 */
@TableName("project_info_time")
public class ProjectInfoTimeEntity {
    /**
     * 项目单号
     */
    @TableId
    private String id;

    /**
     * 接单时间
     */
    private Date orderTime;

    /**
     * 量房时间
     */
    private Date measuringRoomTime;

    /**
     * 签订时间
     */
    private Date signingTime;

    /**
     * 开工时间
     */
    private Date commencementDate;

    /**
     * 完工时间
     */
    private Date makespanDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getMeasuringRoomTime() {
        return measuringRoomTime;
    }

    public void setMeasuringRoomTime(Date measuringRoomTime) {
        this.measuringRoomTime = measuringRoomTime;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public Date getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(Date commencementDate) {
        this.commencementDate = commencementDate;
    }

    public Date getMakespanDate() {
        return makespanDate;
    }

    public void setMakespanDate(Date makespanDate) {
        this.makespanDate = makespanDate;
    }
}
