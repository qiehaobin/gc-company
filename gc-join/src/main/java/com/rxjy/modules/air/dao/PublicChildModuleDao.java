package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.PublicEntity.PublicChildModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;

import java.util.List;

/**
 * describe 公共子类型结果表接口
 *
 * @author yangbin
 * @date 2019-3-22
 */
public interface PublicChildModuleDao extends BaseMapper<PublicChildModuleEntity> {

    /**
     * 根据条件查询人员模块状态
     * @param publicModuleEntity 条件
     * @return 人员模块状态
     */
    List<PublicChildModuleEntity> getAirPeopleModuleStateByCondition(PublicChildModuleEntity publicModuleEntity);
}
