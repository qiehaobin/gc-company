package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.UserinfoJoinc;

import java.util.List;

/***

*@Description 空调人员培训接口

*@Author yangbin
*@Date 2019-03-21
*/
public interface AirPeopleTrainService extends IService<AirPeopleEntity> {

    /**
     * 根据条件查询空调人员培训阶段一段列表信息
     * @param airPeopleEntity 条件
     * @return 空调人员培训阶段一段列表信息
     */
    List<AirPeopleEntity> getAirPeopleTrainList(AirPeopleEntity airPeopleEntity);

    /**
     * 修改空调人员登录状态
     * @param airPeopleEntity
     */
    int updateAirPeopleLoginState(AirPeopleEntity airPeopleEntity);

    /**
     * 添加培训阶段人员的加盟费或风险金
     * @param airPeopleEntity 人员的加盟费或风险金
     * @return
     */
    int operationAirPeopleMoney(AirPeopleEntity airPeopleEntity);

    /**
     * 根据aid查询所有的缴费记录
     * @param aid 主键
     * @return
     */
    List<UserinfoJoinc> getAirPeopleMoneyByAId(int aid);
}
