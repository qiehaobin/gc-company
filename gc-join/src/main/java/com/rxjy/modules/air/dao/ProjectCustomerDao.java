package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.Project.ProjectCustomerEntity;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;

/**
 * 项目阶段接口
 */
public interface ProjectCustomerDao extends BaseMapper<ProjectCustomerEntity> {

    /**
     * 得到项目单号得到项目客户信息
     * @param projectNumber
     * @return
     */
    ProjectCustomerEntity getProjectCustomerByCondition(String projectNumber);
}
