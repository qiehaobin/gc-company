package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.Project.ProjectInformationEntity;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;

import java.util.List;

/**
 * 项目阶段接口
 */
public interface ProjectInformationDao extends BaseMapper<ProjectInformationEntity> {

    /**
     * 根据条件查询当前人员的项目列表
     * @param projectInformationEntity
     * @return
     */
    List<ProjectInformationEntity> getPersonalProjectByCondition(ProjectInformationEntity projectInformationEntity);

}
