package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.ProjectStageDao;
import com.rxjy.modules.air.entity.Project.ProjectStageEntity;
import com.rxjy.modules.air.service.ProjectStageService;
import org.springframework.stereotype.Service;

/**
 * describe 项目阶段接口实现类
 *
 * @author yangbin
 * @date 2019-3-29
 */
@Service
public class ProjectStageServiceImpl extends ServiceImpl<ProjectStageDao, ProjectStageEntity> implements ProjectStageService {
}
