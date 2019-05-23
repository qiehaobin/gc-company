package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.Project.ProjectStageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目阶段接口
 */
public interface ProjectStageDao extends BaseMapper<ProjectStageEntity> {

    /**
     * 添加多条项目阶段信息
     * @param projectStageEntityList
     * @return
     */
    int insertManyProjectStage(@Param("list") List<ProjectStageEntity> projectStageEntityList);
}
