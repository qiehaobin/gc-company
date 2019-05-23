package com.rxjy.modules.air.entity.Project;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * describe 项目客户信息表
 *
 * @author
 * @date 2019-3-29
 */
@TableName("project_customer")
public class ProjectCustomerEntity {
    /**
     * 项目单号
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户联系方式
     */
    private String customerPhone;

    /**
     * 客户身份
     */
    private String customerIdentity;

    /**
     * 客户性别
     */
    private String customerSex;

    /**
     * 客户年龄
     */
    private String customerAge;

    /**
     * 客户注重
     */
    private String customerEmphasize;

    /**
     * 房源类型
     */
    private String housingType;

    /**
     * 房源状态
     */
    private  String housingState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerEmphasize() {
        return customerEmphasize;
    }

    public void setCustomerEmphasize(String customerEmphasize) {
        this.customerEmphasize = customerEmphasize;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public String getHousingState() {
        return housingState;
    }

    public void setHousingState(String housingState) {
        this.housingState = housingState;
    }
}
