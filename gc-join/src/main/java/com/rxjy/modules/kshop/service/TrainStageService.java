package com.rxjy.modules.kshop.service;

import java.util.List;
import java.util.Map;

public interface TrainStageService {
    /**
     * @param params R_S_ID
     *               R_S_CityID 城市ID
     * @return 查询店铺类型
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 查询店铺类型
     */
    List<Map<String, Object>> list_R_TrainStage(Map<String, Object> params);

    /**
     * @param params R_S_ID
     *               R_S_CityID 城市ID
     * @return 查询店铺类型
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 更新店铺类型
     */
    int update_R_TrainStage(Map<String, Object> params);
}
