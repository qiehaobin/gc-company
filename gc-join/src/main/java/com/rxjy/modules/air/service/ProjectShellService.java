package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;
import com.rxjy.modules.air.entity.Project.ProjectStageEntity;

/**
 * 项目阶段接口
 */
public interface ProjectShellService extends IService<ProjectShellEntity> {
    /**
     * 修改个人端项目买单操作
     * @param projectShellEntity
     * @return
     */
    int updatePersonalProjectBuyState(ProjectShellEntity projectShellEntity);
}
