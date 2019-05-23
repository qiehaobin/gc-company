package com.rxjy.modules.kshop.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @创建人 岳耀栎
 * @创建时间 2019/03/25
 */
@Repository
public interface PublicApiDao {

    /**
     * @param params shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-26
     * @功能描述 家具店铺：根据店铺id更新擅长风格
     */
    int updateShopStyleById(Map<String, Object> params);

    /**
     * @param params orgId 公司id
     *               rwdid 项目单号
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-26
     * @功能描述 家具店铺：项目接单
     */

    int updateOrderByOrgId(Map<String, Object> params);

    /**
     *
     * @创建人 岳耀栎
     * @创建时间 2019/03/25
     * @功能描述 家弱公用：获取用户详细信息
     * @params userCard 用户卡号
     *         password 用户密码
     *         roleType 登录类型 1：家具 2：弱电
     * @return 用户信息
     */
    Map<String, Object> getUserInfo(Map<String, Object> params);
}
