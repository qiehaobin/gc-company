package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.PublicEntity.PublicTeamEntity;

import java.util.List;

/**
 * 公共团队信息
 */
public interface PublicTeamDao extends BaseMapper<PublicTeamEntity> {

    /**
     * 根据条件查询空调人员团队信息
     * @param publicTeamEntity 条件
     * @return 团队信息
     */
    List<PublicTeamEntity> getAirPeopleTeamMsgByCondition(PublicTeamEntity publicTeamEntity);
}
