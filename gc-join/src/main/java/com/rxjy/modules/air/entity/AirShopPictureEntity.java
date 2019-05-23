package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("air_shop_picture")
public class AirShopPictureEntity {

    public String aid;
    public String shopid;
    public String shellid;
    public String shoplogoname;
    public String logologo;
    public String logoshoplogo;
    public String logoteam;
    public String synopsis;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getShellid() {
        return shellid;
    }

    public void setShellid(String shellid) {
        this.shellid = shellid;
    }

    public String getShoplogoname() {
        return shoplogoname;
    }

    public void setShoplogoname(String shoplogoname) {
        this.shoplogoname = shoplogoname;
    }

    public String getLogologo() {
        return logologo;
    }

    public void setLogologo(String logologo) {
        this.logologo = logologo;
    }

    public String getLogoshoplogo() {
        return logoshoplogo;
    }

    public void setLogoshoplogo(String logoshoplogo) {
        this.logoshoplogo = logoshoplogo;
    }

    public String getLogoteam() {
        return logoteam;
    }

    public void setLogoteam(String logoteam) {
        this.logoteam = logoteam;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
