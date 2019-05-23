package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;

import java.util.List;

/**
 * describe 公共板块模块结果表接口
 *
 * @author yangbin
 * @date 2019-3-22
 */
public interface PublicModuleDao extends BaseMapper<PublicModuleEntity> {

    /**
     * 根据条件查询公共板块模块信息
     * @param publicModuleEntity 条件
     * @return 公共板块模块信息
     */
    List<PublicModuleEntity> getPublicModuleByCondition(PublicModuleEntity publicModuleEntity);
}
