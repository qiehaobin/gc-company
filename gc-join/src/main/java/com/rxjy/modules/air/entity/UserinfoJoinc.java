package com.rxjy.modules.air.entity;

public class UserinfoJoinc {
    private Integer id;
    private Integer aid;
    private String certificateNo;
    private Double shouldAmount;
    private Double orderMoney;
    private Double money;
    private Integer arrivalAccount;
    private Integer delFlag;
    private String createTime;
    private String updateTime;
    private String remarks;

    /**
     * 金额类型 1、加盟费 2风险金
     */
    private  Integer moneyType;

    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

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

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Double getShouldAmount() {
        return shouldAmount;
    }

    public void setShouldAmount(Double shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getArrivalAccount() {
        return arrivalAccount;
    }

    public void setArrivalAccount(Integer arrivalAccount) {
        this.arrivalAccount = arrivalAccount;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
