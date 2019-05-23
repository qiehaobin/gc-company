package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.ProjectInformationDao;
import com.rxjy.modules.air.dao.ProjectShellDao;
import com.rxjy.modules.air.dao.ProjectStageDao;
import com.rxjy.modules.air.entity.Project.ProjectInformationEntity;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;
import com.rxjy.modules.air.entity.Project.ProjectStageEntity;
import com.rxjy.modules.air.service.ProjectShellService;
import com.rxjy.modules.air.service.ProjectStageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * describe 项目店铺接口实现类
 *
 * @author yangbin
 * @date 2019-3-29
 */
@Service
public class ProjectShellServiceImpl extends ServiceImpl<ProjectShellDao, ProjectShellEntity> implements ProjectShellService {

    private ProjectInformationDao projectInformationDao;
    /**
     * 修改个人端项目买单操作
     * @param projectShellEntity
     * @return
     */
    @Override
    @Transactional
    public int updatePersonalProjectBuyState(ProjectShellEntity projectShellEntity) {

        return baseMapper.updatePersonalProjectBuyState(projectShellEntity);
    }
}
