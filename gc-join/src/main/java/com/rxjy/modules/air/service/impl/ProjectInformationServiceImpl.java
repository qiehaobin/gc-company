package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.ProjectCustomerDao;
import com.rxjy.modules.air.dao.ProjectInformationDao;
import com.rxjy.modules.air.entity.Project.ProjectCustomerEntity;
import com.rxjy.modules.air.entity.Project.ProjectInformationEntity;
import com.rxjy.modules.air.service.ProjectCustomerService;
import com.rxjy.modules.air.service.ProjectInformationService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe 项目店铺接口实现类
 *
 * @author yangbin
 * @date 2019-3-29
 */
@Service
public class ProjectInformationServiceImpl extends ServiceImpl<ProjectInformationDao, ProjectInformationEntity> implements ProjectInformationService {

    /**
     * 根据条件查询当前人员的项目列表
     * @param projectInformationEntity
     * @return
     */
    @Override
    public List<ProjectInformationEntity> getPersonalProjectByCondition(ProjectInformationEntity projectInformationEntity) {
        return baseMapper.getPersonalProjectByCondition(projectInformationEntity);
    }
}
