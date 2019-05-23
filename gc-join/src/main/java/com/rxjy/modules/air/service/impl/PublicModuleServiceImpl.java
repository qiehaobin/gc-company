package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicModuleDao;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;
import com.rxjy.modules.air.service.PublicModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*

 *@Description 公共板块模块结果接口实现类

 *@Author yangbin
 *@Date 2019年3月12日
 */
@Service
public class PublicModuleServiceImpl extends ServiceImpl<PublicModuleDao, PublicModuleEntity> implements PublicModuleService {

    /**
     * 根据条件查询公共板块模块信息
     * @param publicModuleEntity 条件
     * @return 公共板块模块信息
     */
    @Override
    public List<PublicModuleEntity> getPublicModuleByCondition(PublicModuleEntity publicModuleEntity) {
        return baseMapper.getPublicModuleByCondition(publicModuleEntity);
    }
}
