package com.rxjy.modules.recruit.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位标准表
 * 
 * @author kami
 * @email zhangqm@rxjy.com
 * @date 2018-11-18 11:22:54
 */
@TableName("post_standard")
public class PostStandardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 岗位id
	 */
	private Integer postId;
	/**
	 * 岗位名称
	 */
	private String postName;
	/**
	 * 类型id
	 */
	private Integer typeId;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 使用次数
	 */
	private Integer time;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 最小年龄
	 */
	private Integer ageMin;
	/**
	 * 最大年龄
	 */
	private Integer ageMax;
	/**
	 * 工作年限
	 */
	private Integer workingLife;
	/**
	 * 教育程度
	 */
	private String education;
	/**
	 * 专业
	 */
	private String specialty;
	/**
	 * 最低薪资
	 */
	private Integer salaryMin;
	/**
	 * 最高薪资
	 */
	private Integer salaryMax;
	/**
	 * 技能要求
	 */
	private String requirement;
	/**
	 * 删除标识(0正常)
	 */
	private String delFlag;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 设置：主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：岗位id
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	/**
	 * 获取：岗位id
	 */
	public Integer getPostId() {
		return postId;
	}
	/**
	 * 设置：岗位名称
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getPostName() {
		return postName;
	}
	/**
	 * 设置：类型id
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：类型id
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * 设置：类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：使用次数
	 */
	public void setTime(Integer time) {
		this.time = time;
	}
	/**
	 * 获取：使用次数
	 */
	public Integer getTime() {
		return time;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：最小年龄
	 */
	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}
	/**
	 * 获取：最小年龄
	 */
	public Integer getAgeMin() {
		return ageMin;
	}
	/**
	 * 设置：最大年龄
	 */
	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
	}
	/**
	 * 获取：最大年龄
	 */
	public Integer getAgeMax() {
		return ageMax;
	}
	/**
	 * 设置：工作年限
	 */
	public void setWorkingLife(Integer workingLife) {
		this.workingLife = workingLife;
	}
	/**
	 * 获取：工作年限
	 */
	public Integer getWorkingLife() {
		return workingLife;
	}
	/**
	 * 设置：教育程度
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：教育程度
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：专业
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	/**
	 * 获取：专业
	 */
	public String getSpecialty() {
		return specialty;
	}
	/**
	 * 设置：最低薪资
	 */
	public void setSalaryMin(Integer salaryMin) {
		this.salaryMin = salaryMin;
	}
	/**
	 * 获取：最低薪资
	 */
	public Integer getSalaryMin() {
		return salaryMin;
	}
	/**
	 * 设置：最高薪资
	 */
	public void setSalaryMax(Integer salaryMax) {
		this.salaryMax = salaryMax;
	}
	/**
	 * 获取：最高薪资
	 */
	public Integer getSalaryMax() {
		return salaryMax;
	}
	/**
	 * 设置：技能要求
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	/**
	 * 获取：技能要求
	 */
	public String getRequirement() {
		return requirement;
	}
	/**
	 * 设置：删除标识(0正常)
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标识(0正常)
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
}
