package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableId;

public class RsglDiquEntity {

    @TableId
    private  Integer dqId;

    private  String  dqName;

    public Integer getDqId() {
        return dqId;
    }

    public void setDqId(Integer dqId) {
        this.dqId = dqId;
    }

    public String getDqName() {
        return dqName;
    }

    public void setDqName(String dqName) {
        this.dqName = dqName;
    }
}
