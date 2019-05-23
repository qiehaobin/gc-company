package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *  空调经理评价
 *
 *  @author 任何
 *  @date   2019年3月14日
 */
@TableName("air_people_evaluate")
public class AirPeopleEvaluateEntity {

    /**
     * 空调经理评价主键
     */
    @TableId
    private  Integer id;
    /**
     * air_people_answer主键(解答标准表)
     */
    private  Integer pid;
    /**
     * air_people主键(空调经理表)
     */
    private  Integer aid;

    /**
     * 评语
     */
    private  String evaluate;

    /**
     * 1优 2良 3中 4差
     */
    private  Integer standard;
    /**
     * 0正常 1删除
     */
    private  Integer delFlag;
    /**
     * 创建时间
     */
    private  String createDate;
    /**
     * 修改时间
     */
    private  String updateDate;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
