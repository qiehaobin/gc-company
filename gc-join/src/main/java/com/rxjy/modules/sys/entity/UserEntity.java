package com.rxjy.modules.sys.entity;

import java.io.Serializable;

/**
 * 1
 *
 * @author Administrator
 * @create 2018-05-22 17:28
 */

public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private String roleId;		//角色ID
	private String roleName;		//角色名称
	private String headPortrait;	//头像路径
	private String deptId;		//部门编号
	private String deptName;		//部门名称
	private String regionId;		//地区编号
	private String regionName;	//地区名称
	private String jobId;			//职务编号
	private String jobName;		//职务名称
	private String flag;			//0;集团 1:地方
	private String name;			//姓名
	private String cardno;		//卡号
	private String password;		//密码
	private String cityId;		//城id
	private boolean hide;		//隐藏框架页面-ture隐藏，false不隐藏

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
