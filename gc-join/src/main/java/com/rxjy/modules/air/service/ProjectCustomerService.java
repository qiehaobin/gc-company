package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.Project.ProjectCustomerEntity;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;

/**
 * 项目阶段接口
 */
public interface ProjectCustomerService extends IService<ProjectCustomerEntity> {
    /**
     * 得到项目单号得到项目客户信息
     * @param projectNumber
     * @return
     */
    ProjectCustomerEntity getProjectCustomerByCondition(String projectNumber);
}
