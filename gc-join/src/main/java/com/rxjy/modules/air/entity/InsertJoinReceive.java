package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

public class InsertJoinReceive {
    public String province;
    public String region;
    public String companyName;
    public String companyCode;
    public String level;
    public Double shouldAmount;
    public String sourceBy;
    public Double money;
    public Double orderMoney;
    public String companyId;
    public Integer aid;
    public String  voucher;
    public Double  receiptsMoney;
    public Date receiptsTime;

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Double getReceiptsMoney() {
        return receiptsMoney;
    }

    public void setReceiptsMoney(Double receiptsMoney) {
        this.receiptsMoney = receiptsMoney;
    }

    public Date getReceiptsTime() {
        return receiptsTime;
    }

    public void setReceiptsTime(Date receiptsTime) {
        this.receiptsTime = receiptsTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getShouldAmount() {
        return shouldAmount;
    }

    public void setShouldAmount(Double shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public String getSourceBy() {
        return sourceBy;
    }

    public void setSourceBy(String sourceBy) {
        this.sourceBy = sourceBy;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}