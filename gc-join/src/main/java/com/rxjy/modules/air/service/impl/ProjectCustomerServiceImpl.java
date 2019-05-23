package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.ProjectCustomerDao;
import com.rxjy.modules.air.dao.ProjectShellDao;
import com.rxjy.modules.air.entity.Project.ProjectCustomerEntity;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;
import com.rxjy.modules.air.service.ProjectCustomerService;
import com.rxjy.modules.air.service.ProjectShellService;
import org.springframework.stereotype.Service;

/**
 * describe 项目店铺接口实现类
 *
 * @author yangbin
 * @date 2019-3-29
 */
@Service
public class ProjectCustomerServiceImpl extends ServiceImpl<ProjectCustomerDao, ProjectCustomerEntity> implements ProjectCustomerService {
    /**
     * 得到项目单号得到项目客户信息
     * @param projectNumber
     * @return
     */
    @Override
    public ProjectCustomerEntity getProjectCustomerByCondition(String projectNumber) {
        return baseMapper.getProjectCustomerByCondition(projectNumber);
    }
}
