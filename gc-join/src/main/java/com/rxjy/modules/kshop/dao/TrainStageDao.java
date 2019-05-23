package com.rxjy.modules.kshop.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TrainStageDao {

    /**
     * @param
     * @return 查询店铺培训业务、系统、财务
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 查询店铺
     * @功能描述 查询店铺培训业务、系统、财务
     */
    List<Map<String, Object>> list_R_TrainStage(Map<String, Object> params);

    /**
     * @param
     * @return 更新店铺培训业务、系统、财务
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 查询店铺
     * @功能描述 更新店铺培训业务、系统、财务
     */
    int update_R_TrainStage(Map<String, Object> params);
}

