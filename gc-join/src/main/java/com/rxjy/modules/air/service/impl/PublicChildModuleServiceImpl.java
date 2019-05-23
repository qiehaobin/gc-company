package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicChildModuleDao;
import com.rxjy.modules.air.entity.PublicEntity.PublicChildModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;
import com.rxjy.modules.air.service.PublicChildModuleService;
import org.springframework.stereotype.Service;

import java.util.List;

/*

 *@Description 公共板块模块结果接口实现类

 *@Author yangbin
 *@Date 2019年3月12日
 */
@Service
public class PublicChildModuleServiceImpl extends ServiceImpl<PublicChildModuleDao, PublicChildModuleEntity> implements PublicChildModuleService {

    /**
     * 根据条件查询人员模块状态
     * @param publicModuleEntity 条件
     * @return 人员模块状态
     */
    @Override
    public List<PublicChildModuleEntity> getAirPeopleModuleStateByCondition(PublicChildModuleEntity publicModuleEntity) {
        return baseMapper.getAirPeopleModuleStateByCondition(publicModuleEntity);
    }
}
