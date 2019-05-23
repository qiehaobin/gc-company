package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *阶段问答
 *
 *  @author yangbin
 *  @date   2019年3月12日
 */
@TableName("air_people_answer")
public class AirPeopleAnswerEntity {

    /**
     * 阶段问答主键
     */
    @TableId
    private  Integer id;
    /**
     * 1解答 2标准
     */
    private  Integer type;
    /**
     * 阶段 1招聘 2咨询 3考察 4邀约 5集团 6签约
     */
    private  Integer airPeopleStage;


    /**
     * 问题
     */
    private  String problem;
    /**
     * 答案
     */
    private  String answer;

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


    /**
     * 人员编号
     */
    private  Integer aid;

    /**
     * 评语
     */
    private String evaluate;

    /**
     *  评价 1优 2良 3中 4差
     */
    private  String standard;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAirPeopleStage() {
        return airPeopleStage;
    }

    public void setAirPeopleStage(Integer airPeopleStage) {
        this.airPeopleStage = airPeopleStage;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
