package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;
import com.rxjy.modules.air.entity.Project.ProjectStageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目阶段接口
 */
public interface ProjectShellDao extends BaseMapper<ProjectShellEntity> {

    /**
     * 修改个人端项目买单操作
     * @param projectShellEntity
     * @return
     */
    int updatePersonalProjectBuyState(ProjectShellEntity projectShellEntity);
}
