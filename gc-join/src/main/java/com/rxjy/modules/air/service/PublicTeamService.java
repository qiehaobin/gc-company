package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.PublicEntity.PublicTeamEntity;

import java.util.List;

/**
 * describe 公共团队信息接口
 *
 * @author yangbin
 * @date 2019-03-22
 */
public interface PublicTeamService extends IService<PublicTeamEntity> {

    /**
     * 根据条件查询空调人员团队信息
     * @param publicTeamEntity 条件
     * @return 团队信息
     */
    List<PublicTeamEntity> getAirPeopleTeamMsgByCondition(PublicTeamEntity publicTeamEntity);
}
