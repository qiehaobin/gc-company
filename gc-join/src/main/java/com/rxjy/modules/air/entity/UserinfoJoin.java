package com.rxjy.modules.air.entity;

public class UserinfoJoin {
    private Integer id;
    private Integer aid;
    private Double joinFee;
    private String operate;
    private String operateNo;
    private String start;
    private String stop;
    private String uuid;
    private String voucher;

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
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

    public Double getJoinFee() {
        return joinFee;
    }

    public void setJoinFee(Double joinFee) {
        this.joinFee = joinFee;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getOperateNo() {
        return operateNo;
    }

    public void setOperateNo(String operateNo) {
        this.operateNo = operateNo;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

