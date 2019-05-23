package com.rxjy.modules.air.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;
import java.util.List;

/**
 *空调店铺店面类
 *
 *  @author yangbin
 *  @date   2019年3月12日
 */
@TableName("air_people")
public class AirPeopleEntity {

    /**
     * 空调人主键
     */
    @TableId
    private  Integer aid;
    /**
     * 姓名
     */
    private  String airPeopleName;

    /**
     * 城市ID
     */
    private Integer cityid;

    /**
     * 性别1：男，2:女
     */
    private Integer sex;
    /**
     * 电话
     */
    private  String mobile;

    /**
     * 备用手机
     */
    private String spareMobile;

    /**
     * 微信
     */
    private String weChat;
    /**
     * 省级id
     */
    private String provinceCode;
    /**
     * 省份名称
     */
    private String  provinceName;
    /**
     * 市级id
     */
    private  String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 业务员卡号
     */
    private  String createNo;
    /**
     * 业务员姓名
     */
    private  String createUser;
    /**
     * 人员阶段 1招聘 2咨询 3考察 4邀约 5集团 6签约 7 培训
     */
    private  Integer airPeopleStage;
    /**
     * 0正常 1淘汰
     */
    private  Integer airPeopleState;
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
     * 工作经验 0无 1有
     */
    private  Integer experience;
    /**
     * 工作年限
     */
    private  Integer workYear;

    /**
     * 经营类型
     */
    private Integer operateType;

    /**
     * 经历
     */
    private  String expDetail;
    /**
     * 渠道
     */
    private  Integer channel;
    /**
     * 来源
     */
    private  Integer source;

    /**
     * 其他来源
     */
    private String otherSource;

    /**
     * 其他渠道
     */
    private String otherChannel;

    /**
     * 市
     */
    private  String dqName;

    /**
     *  店铺编号
     */
    private  String shopId;

    /**
     * 店铺名称
     */
    private  String airName;

    /**
     * App开启状态 1.开启 2关闭
     */
    public  Integer appState;


    /**
     * PC开启状态 1.开启 2关闭
     */
    public  Integer pcState;


    /**
     * 业务端开启状态 1.开启 2关闭
     */
    public  Integer businessState;


    /**************实力模块******************/
    /**
     *公司规模
     */
    private Integer companyStrength;
    /**
     * 团队规模
     */
    private Integer teamStrength;
    /**
     * 资源规模
     */
    private Integer resourcesStrength;
    /**
     * 人脉
     */
    private Integer peopleStrength;

    /**
     * 代理类型：0 一级  1 厂家 2分销
     */
    private Integer agent;

    /**
     * 人员的状态 1 正常 2异常 3问题 4待定
     */
    @TableField(exist = false)
    private  Integer markState;

    public Integer getMarkState() {
        return markState;
    }

    public void setMarkState(Integer markState) {
        this.markState = markState;
    }

    /**
     * 职务类型
     */
    @TableField(exist = false)
    public  int dutyType;

    /**
     * 登录账号
     */
    @TableField(exist = false)
    public  String loginCode;

    /**
     * 加盟费应缴
     */
    @TableField(exist = false)
    public  double   franchiseFee;

    /**
     * 加盟费实缴
     */
    @TableField(exist = false)
    public double actualPayment;
    /**
     * 风险金应缴
     */
    @TableField(exist = false)
    public double riskDeposit;
    /**
     * 风险金已缴
     */
    @TableField(exist = false)
    public double  riskDepositPayment;

    /**
     * 凭证号
     */
    @TableField(exist = false)
    public  String voucher;

    /**
     * 金额类型 1.加盟费 2、风险金
     */
    public  int moneyType;

    /**
     * 金额缴纳时间
     */
    public  Date moneyTime;

    public Date getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(Date moneyTime) {
        this.moneyTime = moneyTime;
    }

    public int getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(int moneyType) {
        this.moneyType = moneyType;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public double getFranchiseFee() {
        return franchiseFee;
    }

    public void setFranchiseFee(double franchiseFee) {
        this.franchiseFee = franchiseFee;
    }

    public double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(double actualPayment) {
        this.actualPayment = actualPayment;
    }

    public double getRiskDeposit() {
        return riskDeposit;
    }

    public void setRiskDeposit(double riskDeposit) {
        this.riskDeposit = riskDeposit;
    }

    public double getRiskDepositPayment() {
        return riskDepositPayment;
    }

    public void setRiskDepositPayment(double riskDepositPayment) {
        this.riskDepositPayment = riskDepositPayment;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public int getDutyType() {
        return dutyType;
    }

    public void setDutyType(int dutyType) {
        this.dutyType = dutyType;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public String getOtherChannel() {
        return otherChannel;
    }

    public void setOtherChannel(String otherChannel) {
        this.otherChannel = otherChannel;
    }

    /**************实力模块******************/

    /**************招聘模块******************/
    /**
     * 厂家类型：1.厂家 2.总代
      */
    public  int venderType;


    /**
     * 当地实力
     */
    public  String localStrength;
    /**
     * 经营能力
     */
    public  String businessCapability;
    /**
     * appid
     */
    public  String appid;
    /**
     * app卡号
     */
    public  String appCardNo;

    /**
     * 图片信息
     */
    public List<AirPeopleInfoEntity> airPeopleInfoEntityList;

    public List<AirPeopleInfoEntity> getAirPeopleInfoEntityList() {
        return airPeopleInfoEntityList;
    }

    public void setAirPeopleInfoEntityList(List<AirPeopleInfoEntity> airPeopleInfoEntityList) {
        this.airPeopleInfoEntityList = airPeopleInfoEntityList;
    }



    public int getVenderType() {
        return venderType;
    }

    public void setVenderType(int venderType) {
        this.venderType = venderType;
    }

    public String getLocalStrength() {
        return localStrength;
    }

    public void setLocalStrength(String localStrength) {
        this.localStrength = localStrength;
    }

    public String getBusinessCapability() {
        return businessCapability;
    }

    public void setBusinessCapability(String businessCapability) {
        this.businessCapability = businessCapability;
    }

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

    public Integer getAppState() {
        return appState;
    }

    public void setAppState(Integer appState) {
        this.appState = appState;
    }

    public Integer getPcState() {
        return pcState;
    }

    public void setPcState(Integer pcState) {
        this.pcState = pcState;
    }

    public Integer getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Integer businessState) {
        this.businessState = businessState;
    }





    public Integer getCompanyStrength() {
        return companyStrength;
    }

    public void setCompanyStrength(Integer companyStrength) {
        this.companyStrength = companyStrength;
    }

    public Integer getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(Integer teamStrength) {
        this.teamStrength = teamStrength;
    }

    public Integer getResourcesStrength() {
        return resourcesStrength;
    }

    public void setResourcesStrength(Integer resourcesStrength) {
        this.resourcesStrength = resourcesStrength;
    }

    public Integer getPeopleStrength() {
        return peopleStrength;
    }

    public void setPeopleStrength(Integer peopleStrength) {
        this.peopleStrength = peopleStrength;
    }

    public String getOtherSource() {
        return otherSource;
    }

    public void setOtherSource(String otherSource) {
        this.otherSource = otherSource;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSpareMobile() {
        return spareMobile;
    }

    public void setSpareMobile(String spareMobile) {
        this.spareMobile = spareMobile;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAirPeopleName() {
        return airPeopleName;
    }

    public void setAirPeopleName(String airPeopleName) {
        this.airPeopleName = airPeopleName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getCreateNo() {
        return createNo;
    }

    public void setCreateNo(String createNo) {
        this.createNo = createNo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getAirPeopleStage() {
        return airPeopleStage;
    }

    public void setAirPeopleStage(Integer airPeopleStage) {
        this.airPeopleStage = airPeopleStage;
    }

    public Integer getAirPeopleState() {
        return airPeopleState;
    }

    public void setAirPeopleState(Integer airPeopleState) {
        this.airPeopleState = airPeopleState;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public String getExpDetail() {
        return expDetail;
    }

    public void setExpDetail(String expDetail) {
        this.expDetail = expDetail;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getDqName() {
        return dqName;
    }

    public void setDqName(String dqName) {
        this.dqName = dqName;
    }


    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppCardNo() {
        return appCardNo;
    }

    public void setAppCardNo(String appCardNo) {
        this.appCardNo = appCardNo;
    }

}
