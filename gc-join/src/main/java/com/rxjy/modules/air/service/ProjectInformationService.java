package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.Project.ProjectCustomerEntity;
import com.rxjy.modules.air.entity.Project.ProjectInformationEntity;

import java.util.List;

/**
 * 项目信息接口
 */
public interface ProjectInformationService extends IService<ProjectInformationEntity> {
    /**
     * 根据条件查询当前人员的项目列表
     * @param projectInformationEntity
     * @return
     */
    List<ProjectInformationEntity> getPersonalProjectByCondition(ProjectInformationEntity projectInformationEntity);
}
