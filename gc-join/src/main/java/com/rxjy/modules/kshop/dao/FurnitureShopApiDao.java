package com.rxjy.modules.kshop.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 岳耀栎
 * @create 2019-03-04
 * 家具新店铺模板
 */
@Repository
public interface FurnitureShopApiDao {

    /**
     * @param params
     * @return 家具模板列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-04
     * @功能描述 家具店铺：获取新家具模板列表
     */
    List<Map<String, Object>> listShopTemplate(Map<String, Object> params);

    /**
     * @param id 店铺模板id
     * @return 店铺模板信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-04
     * @功能描述 家具店铺模板：根据店铺模板id获取店铺模板信息
     */
    Map<String, Object> getShopTemplate(int id);

    /**
     * @param id 店铺模板id
     * @return 获取店铺模板包括类型列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺模板：根据店铺模板id获取店铺模板包括类型列表
     */
    List<Map<String, Object>> listShopTemplateType(int id);

    /**
     * @param id 店铺模板id
     * @return 获取店铺模板包括产品列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺模板：根据店铺模板id获取店铺模板包括产品列表
     */
    List<Map<String, Object>> listShopTemplateProduct(int id);

    /**
     * @param id 店铺模板id
     * @return 获取店铺模板覆盖城市列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺模板：根据店铺模板id获取店铺模板覆盖城市列表
     */
    List<Map<String, Object>> listShopTemplateCity(int id);

    /**
     * @param params id 店铺模板id
     *               phone 手机认证
     *               identityCard 身份证认证
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺模板：根据店铺模板id更新店铺模板认证设置信息
     */
    int updateAuthenticationMessage(Map<String, Object> params);

    /**
     * @param params id 店铺id
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               shopName 店铺名称
     *               shopLegalPerson 法人代表
     *               shopLegalPersonMobile 法人代表手机号
     *               shopBusinessLeader 业务代表
     *               shopBusinessLeaderMobile 业务代表手机号
     *               shopRegisteredCapital 注册资金
     *               shopQualificationsUrl 资质URL
     *               shopBusinessCard 名片URL
     *               shopBriefIntroduction 店铺简介
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id更新店铺基础信息
     */
    int updateShopBaseMessage(Map<String, Object> params);

    /**
     * @param id 店铺id
     * @return 店铺基础信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺：根据店铺id获取店铺基础信息
     */
    Map<String, Object> getShopBaseMessage(int id);

    /**
     * @param id 店铺模板id
     * @return 店铺模板所需认证信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺：根据店铺id获取店铺模板所需认证信息
     */
    List<Map<String, Object>> listShopTemplateAuthenticationMessage(int id);

    /**
     * @param params
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家弱公用：获取城列表
     */
    List<Map<String, Object>> listCity(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               cityId 城市id
     *               cityAnalysis 城市分析
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id更新城市分析
     */
    int updateShopCityMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               cityId 城市id
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id以及城市id获取城市分析
     */
    List<Map<Object, Object>> getShopCityMessage(Map<String, Object> params);

    /**
     * @param params cityId 城id
     * @return 家具店铺模板列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-07
     * @功能描述 家具店铺：根据城id获取该城覆盖的家具店铺模板列表
     */
    List<Map<String, Object>> listShopTemplateByCityId(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               shopName 店铺名称
     *               publicBankName 对公账户开户行名称
     *               publicBankAccount 对公账户开户行账号
     *               privateBankName 对私账户开户行名称
     *               privateBankAccount 对私账户开户行账号
     *               shopPeopleCardFace 财务代表人身份证头像面照片URL
     *               shopPeopleCardOpposite 财务代表人身份证国徽面照片URL
     *               shopPeopleCardHold 财务代表人手持身份证正面照URL
     *               shopPublicPhotoFace 对公账户银行卡正面照片URL
     *               shopPublicPhotoOpposite 对公账户银行卡反面照片URL
     *               shopPrivatePhotoFace 对私账户银行卡正面照片URL
     *               shopPrivatePhotoOpposite 对私账户银行卡反面照片URL
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-07
     * @功能描述 家具店铺：根据店铺id更新店铺财务信息
     */
    int updateShopFinanceMessage(Map<String, Object> params);

    /**
     * @param id 店铺id
     * @return 店铺财务信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺：根据店铺id获取店铺财务信息
     */
    Map<String, Object> getShopFinanceMessage(int id);

    /**
     * @param params type 产品类型 0：家具 1：弱电
     *               shopId 店铺id
     *               cityId 城id
     * @return 产品及产品分类列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：根据店铺及店铺类型获取产品及产品分类列表
     */
    List<Map<String, Object>> listProductAndSubjectInfoByShopType(Map<String, Object> params);

    /**
     * @param params type 0：店铺 1：店铺模板
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增家具店铺
     */
    int addNewShopTemplate(Map<String, Object> params);

    /**
     * @param params type 0：店铺 1：店铺模板
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增家具店铺基础信息
     */
    int addBaseMessage(Map<String, Object> params);

    /**
     * @param params shopType 0：店铺 1：店铺模板
     *               shopId 店铺id
     *               categoryList 类别列表
     *               createUser 操作人
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增或更新家具店铺包含类别与产品
     */
    int updateShopCategoryAndProduct(Map<String, Object> params);

    /**
     * @param params shopType 0：店铺 1：店铺模板
     *               shopId 店铺id
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：根据shopId与shopType查询家具店铺包含类别与产品
     */
    List<Map<String, Object>> listShopCategoryAndProduct(Map<String, Object> params);

    /**
     * @param params shopType 0：店铺 1：店铺模板
     *               shopId 店铺id
     *               categoryList 类别列表
     *               createUser 操作人
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：根据shopId与shopType删除家具店铺包含类别与产品
     */
    int deleteShopCategoryAndProduct(Map<String, Object> params);

    /**
     * @param params type 产品类型 0：家具 1：弱电
     *               shopId 店铺id
     *               shopType 0：店铺 1：店铺模板
     * @return 当前店铺选中的产品类别及产品信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息
     */
    List<Map<String, Object>> listProductAndSubjectInfoByShopIdAndShopType(Map<String, Object> params);

    /**
     * @param params type 产品类型 0：家具 1：弱电
     *               shopId 店铺id
     *               shopType 0：店铺 1：店铺模板
     *               categoryCode 类别编号
     * @return 获取当前店铺选中指定类别下的产品信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息
     */
    List<Map<String, Object>> listProductAndSubjectInfoByCategoryCode(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 产品详情
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编码查询产品详情
     */
    List<Map<String, Object>> getProductInfo(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 产品图片表相关信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品图片表相关信息
     */
    List<Map<String, Object>> listImageByProductCode(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 获取价格
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品获取价格
     */
    List<Map<String, Object>> listPriceByProductCode(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 获取价格
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品获取价格
     */
    List<Map<String, Object>> listPriceByProductCodeForFurniture(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 获取价格
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品获取颜色信息
     */
    List<Map<String, Object>> listColorByProductCode(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 获取小样信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编号获取小样信息
     */
    List<Map<String, Object>> listStyleByProductCode(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 获取小样信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和城Id编辑店铺覆盖类型
     */
    int addShopProductCategory(Map<String, Object> params);

    /**
     * @param params productCode 产品编号
     * @return 获取小样信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-11
     * @功能描述 家具店铺：根据店铺id和城Id删除店铺覆盖类型
     */
    int deleteShopProductCategory(Map<String, Object> params);

    /**
     * @param params shopId 产品编号
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               productCode 产品code
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-11
     * @功能描述 家具店铺：根据产品编码、店铺id与店铺类型查询产品列表
     */
    List<Map<String, Object>> listShopProductByShopIdAndCategoryCode(Map<String, Object> params);

    /**
     * @param params id 店壳编号 空调KT-001 家具JJ-001 弱电RD-001
     *               shop_name 店铺名称
     *               shop_type 店铺类型
     *               shop_stage 店铺阶段 00空壳 10招 20培 30留 40用 50离
     *               shop_information_id 店铺信息编号
     *               city_id 城市编号
     *               del_flag 删除标识 0：正常 1：删除
     *               create_date 创建时间
     *               create_date 更新时间
     *               remarks 备注
     * @return 店铺壳子列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：查询店铺壳子列表
     */
    List<Map<String, Object>> listShopShell(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型
     * @return 店铺壳子列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：根据店铺id与店铺类型查询已选类目列表及类目信息
     */
    List<Map<String, Object>> listShopCategoryByShopIdAndCategoryCode(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               categoryCode 类别编码
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表
     */
    List<Map<String, Object>> listCategoryByShopIdAndCategoryCode(Map<String, Object> params);

    /**
     * @param params id 店壳编号 空调KT-001 家具JJ-001 弱电RD-001
     *               shop_name 店铺名称
     *               shopCategory 店铺类型
     *               shopStage 店铺阶段 00空壳 10招 20培 30留 40用 50离
     *               shopTypeId 店铺信息编号
     *               cityId 城市编号
     *               delFlag 删除标识 0：正常 1：删除
     *               createDate 创建时间
     *               updateDate 更新时间
     *               remarks 备注
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增店铺壳子
     */
    int addShopShell(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码查询该分类下产品数量
     */
    List<Map<String, Object>> countProductFromCategory(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id更新该类别工艺信息
     */
    int updateCategoryTechnics(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     * @return 当前店铺下类别工艺列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id获取该类别工艺列表
     */
    List<Map<String, Object>> listCategoryTechnicsByShopIdAndCategoryCode(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     *               technicsDesc 工艺描述
     *               technicsPrice 工艺价格
     *               technicsTag 工艺标签
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id新增该类别工艺信息
     */
    int addCategoryTechnics(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     *               mealName 套餐名称
     *               mealPrice 套餐价格
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：上传套餐
     */
    int addShopMeal(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据店铺id套餐列表
     */
    List<Map<String, Object>> listShopMealByShopId(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     *               id：套餐id
     *               mealName 套餐名称
     *               mealPrice 套餐价格
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：上传套餐套餐内产品
     */
    int addShopMealProduct(Map<String, Object> params);

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     *               id：套餐id
     *               mealName 套餐名称
     *               mealPrice 套餐价格
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：更新套餐内产品信息
     */
    int updateShopMealProduct(Map<String, Object> params);

    /**
     * @param params id 套餐id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据套餐id更新套餐
     */
    int updateShopMealByMealId(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     * @return 铺id获取购物车列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据店铺id获取购物车列表
     */
    List<Map<String, Object>> listShopCarByShopId(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               productCode 产品编号
     *               productPrice 产品价格
     *               productNum 产品数量
     *               userId 用户id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据shopId添加产品到购物车
     */
    int addShopCar(Map<String, Object> params);

    /**
     * @param params productCode 类别编码
     *               shopId 店铺id
     *               productModel 套餐名称
     *               productPrice 套餐价格
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-15
     * @功能描述 家具店铺：根据店铺id与产品型号更新产品价格
     */
    int updateProductPriceByShopIdAndProductModel(Map<String, Object> params);

    /**
     * @param params productCode 类别编码
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-15
     * @功能描述 家具店铺：根据店铺id查询产品工艺信息
     */
    List<Map<String, Object>> getTechnicsMessage(Map<String, Object> params);

    /**
     * @param params id 套餐id
     *               productCodes 产品编码
     * @return 铺id获取购物车列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据套餐id或产品编码查询套餐内产品列表
     */
    List<Map<String, Object>> listProductByMealId(Map<String, Object> params);

    /**
     * @param params productCodes 产品编码
     *               mealId 套餐id
     *               mealName 套餐名称
     *               mealPrice 套餐价格
     *               mealDesc 套餐描述
     *               mealImg 套餐主图
     *               state 套餐状态
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-15
     * @功能描述 家具店铺：根据套餐id更新套餐信息
     */
    int updateShopMeal(Map<String, Object> params);

    /**
     * @param params productCode 产品编码
     *               mealId 套餐id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-15
     * @功能描述 家具店铺：根据套餐id删除店铺套餐内指定单品
     */
    int deleteMealProduct(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               productCode 产品编码
     *               productParent 父级编码
     *               productName 产品名称
     *               productModel 产品类型
     *               productImage 产品主图
     *               productPrice 产品价格
     *               productExplain 产品特征
     *               productDesc 产品描述
     *               productPurpose 产品用途
     *               productKeys 产品关键词
     *               productNumber 产品数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-16
     * @功能描述 家具店铺：根据店铺id上传自定义产品
     */
    int addPrivateProduct(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               productCode 产品编码
     *               productParent 父级编码
     *               productName 产品名称
     *               productModel 产品类型
     *               productImage 产品主图
     *               productPrice 产品价格
     *               productExplain 产品特征
     *               productDesc 产品描述
     *               productPurpose 产品用途
     *               productKeys 产品关键词
     *               productNumber 产品数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-16
     * @功能描述 家具店铺：根据店铺id查询自定产品列表
     */
    List<Map<String, Object>> listPrivateProduct(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     * @return 店铺人员配置信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id查询店铺人员配置信息
     */
    List<Map<String, Object>> getShopStaffingMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     * @return 查询各岗位详细信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id查询各岗位详细信息
     */
    List<Map<String, Object>> listRoleMessageList(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               employeeId 用户id
     *               userName 用户姓名
     *               userSex 用户性别
     *               userRole 用户角色
     *               userPhone 用户手机号
     *               userAge 用户年龄
     *               headImg 用户头像
     *               HeadIDCardImg 用户身份证头像面
     *               EmblemIDCardImg 用户身份证国徽面
     *               userAddress 用户地址
     *               emergencyUserName 紧急联系人姓名
     *               emergencyUserPhone 紧急联系人手机号
     *               emergencyUserSex 紧急联系人性别
     *               emergencyUserRelationship 紧急联系人与用户关系
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id和用户id更新用户信息
     */
    int updateEmployeeMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               employeeRole 用户角色
     *               employeeNumber 用户数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id和用户角色添加用户数量
     */
    int addEmployees(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               employeeRole 用户角色
     *               employeeNumber 用户数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id和用户角色添加用户壳子
     */
    int addEmployeesMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               licenseImg 营业执照
     *               permitImg 开户许可证
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新营业执照信息
     */
    int updateShopLicenseMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               imgPublicSeal 公章
     *               imgPrivateSeal 私章
     *               imgContractSeal 合同章
     *               imgPersonalSeal 个人章
     *               imgInvoiceSeal 发票专用章
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺印章信息
     */
    int updateShopSealMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               messageMoney 信息费
     *               riskMoney 风险费
     *               managementMoney 管理费
     *               invoiceRate 税率
     *               privateAccount 对私账户
     *               publicAccount 对公账户
     *               finaceSeal 财务章
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺财务信息
     */
    int updateShopFinaceMessage(Map<String, Object> params);

    /**
     * @param params shopId 店壳编号
     *               workAddress 办公地址
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺信息
     */
    int updateShopShellMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               joinContract 合同正本
     *               joinContractElse 合同副本
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺加盟合同信息
     */
    int updateShopJoinContractMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     *               houseImg 合同正本
     *               houseEnclosureImg 合同副本
     *               houseElseImg 合同其他
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺房屋合同信息
     */
    int updateShopHouseContractMessage(Map<String, Object> params);

    /**
     * @param params shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-25
     * @功能描述 家具店铺：根据店铺id查询店铺擅长风格
     */
    List<Map<String, Object>> listShopStyleById(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型下的产品类型和类目之间的关系
     * @param params
     * @return 空对象
     */
    int edit_ShopSubjectMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型下的产品类型和类目之间的关系
     * @param params
     * @return 空对象
     */
    int delete_ShopSubjectMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 根据城市ID和类目编号获取店铺信息
     * @param
     * @return 根据城市ID和类目编号获取店铺信息
     */
    List<Map<String, Object>> list_ShopSubjectMapping(Map<String, Object> params);

    /**
     * @param params
     * @return 获取店铺分类
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺分类
     */
    List<Map<String, Object>> listShopSubjectAuxiliary(Map<String, Object> params);
    /**
     * @param params
     * @return 获取店铺分类
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺分类
     */
    List<Map<String, Object>> listShopSubjectAuxiliary1(Map<String, Object> params);

    /**
     * @param params
     * @return 获取店铺类型下的产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    List<Map<String, Object>> listShopProduct(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 获取产品下的图片
     * @param
     * @return
     */
    List<Map<String, Object>> list_ProductImage(Map<String, Object> params);

    /**
     * @param params
     * @return 获取店铺类型下辅料产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    List<Map<String, Object>> listShopProductTechnology(Map<String, Object> params);

    /**
     * @param params
     * @return 获取店铺类型下的产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    List<Map<String, Object>> listShopProductAuxiliary(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 获取产品下的型号
     * @param
     * @return
     */
    List<Map<String, Object>> list_ProductModelSpecification(Map<String, Object> params);

    /**
     * @param params
     * @return 获取店铺类型下辅料产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    List<Map<String, Object>> listProductTechnology(Map<String, Object> params);

    /**
     * @param params
     * @return 店铺产品辅料类别映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品辅料类别映射关系列表
     */
    List<Map<String, Object>> listShopSubjectAuxiliaryMapping(Map<String, Object> params);

    /**
     * @param params
     * @return 店铺产品工艺类别映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品工艺类别映射关系列表
     */
    List<Map<String, Object>> listShopSubjectTechnologyMapping(Map<String, Object> params);

    /**
     * @param params
     * @return 店铺产品辅料产品映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品辅料产品映射关系列表
     */
    List<Map<String, Object>> listShopProductAuxiliaryMapping(Map<String, Object> params);

    /**
     * @param params
     * @return 店铺产品工艺产品映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品工艺产品映射关系列表
     */
    List<Map<String, Object>> listShopProductTechnologyMapping(Map<String, Object> params);

    /**
     * @param params
     * @return 获取店铺类型下的产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    List<Map<String, Object>> listProductAuxiliary(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺关联辅料类
     * @param params
     * @return 空对象
     */
    int edit_ShopSubjectAuxiliaryMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺关联辅料类
     * @param params
     * @return 空对象
     */
    int delete_ShopSubjectAuxiliaryMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺下工艺类关系
     * @param params
     * @return 空对象
     */
    int edit_ShopSubjectTechnologyMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺下工艺类关系
     * @param params
     * @return 空对象
     */
    int delete_ShopSubjectTechnologyMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型关联的产品对应的辅料
     * @param params
     * @return 空对象
     */
    int edit_ShopProductAuxiliaryMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺类型关联的产品对应的辅料
     * @param params
     * @return 空对象
     */
    int delete_ShopProductAuxiliaryMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型关联工艺关系
     * @param params
     * @return 空对象
     */
    int edit_ShopProductTechnologyMapping(Map<String, Object> params);

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺类型关联工艺关系
     * @param params
     * @return 空对象
     */
    int delete_ShopProductTechnologyMapping(Map<String, Object> params);
    /**
     * @创建人 岳耀栎
     * @创建时间 2019-04-16
     * @功能描述 上传加盟商加盟费及风险押金信息
     * @param params  money:缴纳金额
     *                shopShellId 店壳id
     *                orgId 公司id
     *                payTime:缴纳日期
     *                payUser:上传人
     *                payImg:缴纳凭证
     *                type:上传类型 1：加盟费 2：风险押金
     * @return 影响记录数
     */
    int addFundMessage(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019-04-16
     * @功能描述 获取加盟商加盟费及风险押金信息
     * @param params shopId 店壳id
     * @return 获取加盟商加盟费及风险押金信息
     */
    List<Map<String, Object>> listBusinessMoney(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019-04-16
     * @功能描述 查询加盟店铺办公地址信息
     * @param params shopId 店壳id
     * @return 加盟店铺办公地址信息
     */
    Map<String, Object> getShopAddressByShopShellId(Map<String, Object> params);

    /**
     * @param params shopId 店壳编号
     *               workAddress 办公地址
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 加盟店铺办公地址信息
     */
    int addShopShellMessage(Map<String, Object> params);
}
