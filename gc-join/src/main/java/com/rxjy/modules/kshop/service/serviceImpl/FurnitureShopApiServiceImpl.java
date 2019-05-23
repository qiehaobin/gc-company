package com.rxjy.modules.kshop.service.serviceImpl;


import com.rxjy.modules.kshop.service.FurnitureShopApiService;
import com.rxjy.modules.kshop.dao.FurnitureShopApiDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 岳耀栎
 * @create 2019-03-04
 * 家具新店铺模板
 */
@Service
public class FurnitureShopApiServiceImpl implements FurnitureShopApiService {

    @Autowired
    FurnitureShopApiDao furnitureShopApiMapper;

    /**
     * @param params
     * @return 家具模板列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-04
     * @功能描述 获取新家具模板列表
     */
    @Override
    public List<Map<String, Object>> listShopTemplate(Map<String, Object> params) {
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopTemplate(params);
        for (int i = 0; i < result.size(); i ++) {
            Map<String, Object> param = new HashMap<>();
            param.put("ShopCode", result.get(i).get("id"));
            param.put("ParentCode", "0");
            result.get(i).put("SubjectList", furnitureShopApiMapper.list_ShopSubjectMapping(param));
        }
        return result;
    }

    /**
     * @param id 店铺模板id
     * @return 店铺模板信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-04
     * @功能描述 家具店铺模板：根据店铺模板id获取店铺模板信息
     */
    @Override
    public Map<String, Object> getShopTemplate(int id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        //查询店铺详情信息
        resultMap = furnitureShopApiMapper.getShopTemplate(id);
        // 查询店铺所需认证信息
        resultMap.put("authenticationMessage", furnitureShopApiMapper.listShopTemplateAuthenticationMessage(id));
        // 查询店铺所属类型
        resultMap.put("shopType", furnitureShopApiMapper.listShopTemplateType(id));
        // 查询店铺包含产品
        resultMap.put("shopProduct", furnitureShopApiMapper.listShopTemplateProduct(id));
        // 查询店铺覆盖城市
        resultMap.put("shopCity", furnitureShopApiMapper.listShopTemplateCity(id));
        // 查询店铺基础信息
        resultMap.put("shopBaseMessage", furnitureShopApiMapper.getShopBaseMessage(id));
        // 查询店铺财务信息
        resultMap.put("shopFinanceMessage", furnitureShopApiMapper.getShopFinanceMessage(id));
        return resultMap;
    }


    /**
     * @param json id 店铺模板id
     *             phone 手机认证
     *             identityCard 身份证认证
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺模板：根据店铺模板id更新店铺模板认证设置信息
     */
    @Override
    public int updateAuthenticationMessage(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);

        return furnitureShopApiMapper.updateAuthenticationMessage(params);
    }

    /**
     * @param json id 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             shopName 店铺名称
     *             shopLegalPerson 法人代表
     *             shopLegalPersonMobile 法人代表手机号
     *             shopBusinessLeader 业务代表
     *             shopBusinessLeaderMobile 业务代表手机号
     *             shopRegisteredCapital 注册资金
     *             shopQualificationsUrl 资质URL
     *             shopBusinessCard 名片URL
     *             shopBriefIntroduction 店铺简介
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id更新店铺基础信息
     */
    @Override
    public int updateShopBaseMessage(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.updateShopBaseMessage(params);
    }

    /**
     * @param json
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家弱公用：获取城列表
     */
    @Override
    public List<Map<String, Object>> listCity(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.listCity(params);
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             cityId 城市id
     *             cityAnalysis 城市分析
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id更新城市分析
     */
    @Override
    public int updateShopCityMessage(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.updateShopCityMessage(params);
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             cityId 城市id
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id以及城市id获取城市分析
     */
    @Override
    public List<Map<Object, Object>> getShopCityMessage(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.getShopCityMessage(params);
    }

    /**
     * @param json cityId 城id
     * @return 家具店铺模板列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-07
     * @功能描述 家具店铺：根据城id获取该城覆盖的家具店铺模板列表
     */
    @Override
    public List<Map<String, Object>> listShopTemplateByCityId(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.listShopTemplateByCityId(params);
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             shopName 店铺名称
     *             publicBankName 对公账户开户行名称
     *             publicBankAccount 对公账户开户行账号
     *             privateBankName 对私账户开户行名称
     *             privateBankAccount 对私账户开户行账号
     *             shopPeopleCardFace 财务代表人身份证头像面照片URL
     *             shopPeopleCardOpposite 财务代表人身份证国徽面照片URL
     *             shopPeopleCardHold 财务代表人手持身份证正面照URL
     *             shopPublicPhotoFace 对公账户银行卡正面照片URL
     *             shopPublicPhotoOpposite 对公账户银行卡反面照片URL
     *             shopPrivatePhotoFace 对私账户银行卡正面照片URL
     *             shopPrivatePhotoOpposite 对私账户银行卡反面照片URL
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-07
     * @功能描述 家具店铺：根据店铺id更新店铺财务信息
     */
    @Override
    public int updateShopFinanceMessage(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.updateShopFinanceMessage(params);
    }

    /**
     * @param json type 产品类型 0：家具 1：弱电
     *             shopId 店铺id
     *             cityId 城id
     * @return 产品及产品分类列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：根据店铺及店铺类型获取产品及产品分类列表
     */
    @Override
    public List<Map<String, Object>> listProductAndSubjectInfoByShopType(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.listProductAndSubjectInfoByShopType(params);
    }

    /**
     * @param params type 0：店铺 1：店铺模板
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增家具店铺
     */
    @Override
    public int addNewShopTemplate(Map<String, Object> params) {
        int a = furnitureShopApiMapper.addNewShopTemplate(params);
//        List<Map<String, Object>> listShop = furnitureShopApiMapper.listShopTemplate(params);
//        int shopId = (int) listShop.get(listShop.size() - 1).get("id");
//        // 新增基础信息
//        params.put("shopId", shopId);
//        int b = furnitureShopApiMapper.addBaseMessage(params);
        return a;
    }

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
    @Override
    public int updateShopCategoryAndProduct(Map<String, Object> params) {
        // 根据shopId与shopType判断是否已做类别映射，存在先删除后添加、
        List<Map<String, Object>> resultList = new ArrayList<>();
        resultList = furnitureShopApiMapper.listShopCategoryAndProduct(params);
        if (resultList.size() > 0) {
            furnitureShopApiMapper.deleteShopCategoryAndProduct(params);
        }

        //得到分类id或编号，构建循环插入数据库

        return furnitureShopApiMapper.updateShopCategoryAndProduct(params);
    }

    /**
     * @param json type 产品类型 0：家具 1：弱电
     *             shopId 店铺id
     *             shopType 0：店铺 1：店铺模板
     * @return 当前店铺选中的产品类别及产品信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息
     */
    @Override
    public List<Map<String, Object>> listProductAndSubjectInfoByShopIdAndShopType(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.listProductAndSubjectInfoByShopIdAndShopType(params);
    }

    /**
     * @param json type 产品类型 0：家具 1：弱电
     *             shopId 店铺id
     *             shopType 0：店铺 1：店铺模板
     *             categoryCode 类别编号
     * @return 获取当前店铺选中指定类别下的产品信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息
     */
    @Override
    public List<Map<String, Object>> listProductAndSubjectInfoByCategoryCode(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        if (null != params.get("categoryCode")) {
            params.put("sid", "0" + params.get("categoryCode").toString());
        }
        return furnitureShopApiMapper.listProductAndSubjectInfoByCategoryCode(params);
    }

    /**
     * @param json productCode 产品编号
     * @return 产品详情
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编码查询产品详情
     */
//
    @Override
    public Map<String, Object> getProductInfo(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("priceResultList", listPriceByProductCode(params));
        //产品原信息
        resultMap.put("baseMessage", furnitureShopApiMapper.getProductInfo(params));

        //查询产品工艺信息
        resultMap.put("technicsMessage", furnitureShopApiMapper.getTechnicsMessage(params));

        return resultMap;
    }

    /**
     * @param json productCode 产品编号
     * @return 产品详情
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编码查询产品详情
     */
    @Override
//    @DataSource(name = "second")
    public Map<String, Object> getProductInfoFromProductFurniture(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        Map<String, Object> resultMap = new HashMap<>();
        //根据产品Code查询产品图片表相关信息
        resultMap.put("imgResultList", listImageByProductCode(params));
        //根据产品Code查询产品获取价格
        resultMap.put("priceResultList", listPriceByProductCodeForFurniture(params));
        //根据产品Code查询产品获取颜色信息
        resultMap.put("colorResultList", listColorByProductCode(params));
        //根据产品编号获取小样信息
        resultMap.put("styleResultList", listStyleByProductCode(params));
        return resultMap;
    }

    /**
     * @param params productCode 产品编号
     * @return 产品详情
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品图片表相关信息
     */
//    @DataSource(name = "second")
    private List<Map<String, Object>> listImageByProductCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listImageByProductCode(params);
    }

    /**
     * @param params productCode 产品编号
     * @return 获取价格
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品获取价格
     */
//    @DataSource(name = "second")
    private List<Map<String, Object>> listPriceByProductCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listPriceByProductCode(params);
    }

    /**
     * @param params productCode 产品编号
     * @return 获取价格
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品获取价格
     */
//    @DataSource(name = "second")
    private List<Map<String, Object>> listPriceByProductCodeForFurniture(Map<String, Object> params) {
        return furnitureShopApiMapper.listPriceByProductCodeForFurniture(params);
    }

    /**
     * @param params productCode 产品编号
     * @return 获取颜色信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品Code查询产品获取颜色信息
     */
//    @DataSource(name = "second")
    private List<Map<String, Object>> listColorByProductCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listColorByProductCode(params);
    }

    /**
     * @param params productCode 产品编号
     * @return 获取小样信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编号获取小样信息
     */
//    @DataSource(name = "second")
    private List<Map<String, Object>> listStyleByProductCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listStyleByProductCode(params);
    }

    /**
     * @param json shopId 产品编号
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             productCode 产品code
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-11
     * @功能描述 家具店铺：根据店铺id与店铺类型更新店铺包含产品与类别信息
     */
    @Override
    public int updateShopTypeAndProduct(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        String productCode = ((JSONObject) params).getString("productCode");
        productCode = productCode.substring(1, productCode.length() - 1);
        List<String> lis = Arrays.asList(productCode.split(","));
        int a = 0;
        //删除类别映射,
        int b = furnitureShopApiMapper.deleteShopProductCategory(params);
        for (String string : lis) {
            string = string.substring(1, string.length() - 1);
            params.put("productCode", string);
            a = furnitureShopApiMapper.addShopProductCategory(params);
        }
        return a;
    }

    /**
     * @param json shopId 产品编号
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             productCode 产品code
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-11
     * @功能描述 家具店铺：根据产品编码、店铺id与店铺类型查询产品列表
     */
    @Override
    public List<Map<String, Object>> listShopProductByShopIdAndCategoryCode(JSONObject json) {
        Map<String, Object> params = JSONObject.fromObject(json);
        return furnitureShopApiMapper.listShopProductByShopIdAndCategoryCode(params);
    }

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
    @Override
//    @DataSource(name = "second")
    public List<Map<String, Object>> listShopShell(Map<String, Object> params) {
        return furnitureShopApiMapper.listShopShell(params);
    }

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型
     * @return 店铺壳子列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：根据店铺id与店铺类型查询已选类目列表及类目信息
     */
    @Override
    public List<Map<String, Object>> listShopCategoryByShopIdAndCategoryCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listShopCategoryByShopIdAndCategoryCode(params);
    }

    /**
     * @param params shopId 店铺id
     *               shopType 店铺类型 0：店铺 1：店铺模板
     *               categoryCode 类别编码
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表
     */
    @Override
    public List<Map<String, Object>> listCategoryByShopIdAndCategoryCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listCategoryByShopIdAndCategoryCode(params);
    }

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
    @Override
    public int addShopShell(List<Map<String, Object>> params) {
        int a = 0;
        for(int i = 0; i < params.size(); i++){
            furnitureShopApiMapper.addShopShell(params.get(i));
        }

        return a;
    }

    /**
     * @param params categoryCode 类别编码
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码查询该分类下产品数量
     */
    @Override
    public List<Map<String, Object>> countProductFromCategory(Map<String, Object> params) {
        return furnitureShopApiMapper.countProductFromCategory(params);
    }

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id更新该类别工艺信息
     */
    @Override
    public int updateCategoryTechnics(Map<String, Object> params) {
        return furnitureShopApiMapper.updateCategoryTechnics(params);
    }

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
    @Override
    public int addCategoryTechnics(Map<String, Object> params) {
        return furnitureShopApiMapper.addCategoryTechnics(params);
    }

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     * @return 当前店铺下类别工艺列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id获取该类别工艺列表
     */
    @Override
    public List<Map<String, Object>> listCategoryTechnicsByShopIdAndCategoryCode(Map<String, Object> params) {
        return furnitureShopApiMapper.listCategoryTechnicsByShopIdAndCategoryCode(params);
    }

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
    @Override
    public int addShopMeal(Map<String, Object> params) {

        String uuid = UUID.randomUUID().toString();
        params.put("id", uuid);
        //新增套餐
        int a = furnitureShopApiMapper.addShopMeal(params);
        //新增套餐内产品
        String productList = params.get("mealProducts").toString();
        String[] stringList = productList.split(",");
        for (int i = 0; i < stringList.length; i++) {
            params.put("productCode", stringList[i]);
            furnitureShopApiMapper.addShopMealProduct(params);
            //查询产品信息，更新套餐信息
            Map<String, Object> paramsMap = furnitureShopApiMapper.getProductInfo(params).get(0);
            paramsMap.put("mealId", uuid);
            paramsMap.put("productCode", stringList[i]);
            furnitureShopApiMapper.updateShopMealProduct(paramsMap);

        }
        return a;
    }

    /**
     * @param params categoryCode 类别编码
     *               shopId 店铺id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据店铺id套餐列表
     */
    @Override
    public List<Map<String, Object>> listShopMealByShopId(Map<String, Object> params) {
        return furnitureShopApiMapper.listShopMealByShopId(params);
    }

    /**
     * @param params id 套餐id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据套餐id更新套餐
     */
    @Override
    public int updateShopMealByMealId(Map<String, Object> params) {
        return furnitureShopApiMapper.updateShopMealByMealId(params);
    }

    /**
     * @param params shopId 店铺id
     * @return 铺id获取购物车列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据店铺id获取购物车列表
     */
    @Override
    public List<Map<String, Object>> listShopCarByShopId(Map<String, Object> params) {
        return furnitureShopApiMapper.listShopCarByShopId(params);
    }

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
    @Override
    public int addShopCar(Map<String, Object> params) {
        return furnitureShopApiMapper.addShopCar(params);
    }

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
    @Override
    public int updateProductPriceByShopIdAndProductModel(Map<String, Object> params) {
        return furnitureShopApiMapper.updateProductPriceByShopIdAndProductModel(params);
    }

    /**
     * @param params id 套餐id
     *               productCodes 产品编码
     * @return 铺id获取购物车列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据套餐id或产品编码查询套餐内产品列表
     */
    @Override
    public List<Map<String, Object>> listProductByMealId(Map<String, Object> params) {
        List<String> stringList = Arrays.asList(params.get("productCodes").toString().split(","));
        params.put("stringList", stringList);
        return furnitureShopApiMapper.listProductByMealId(params);
    }

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
    @Override
    public int updateShopMeal(Map<String, Object> params) {

        return furnitureShopApiMapper.updateShopMeal(params);
    }

    /**
     * @param params productCode 产品编码
     *               mealId 套餐id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-16
     * @功能描述 家具店铺：根据套餐id与单品id删除套餐内指定单品
     */
    @Override
    public int deleteMealProduct(Map<String, Object> params) {
        return furnitureShopApiMapper.deleteMealProduct(params);
    }

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
    @Override
    public int addPrivateProduct(Map<String, Object> params) {
        return furnitureShopApiMapper.addPrivateProduct(params);
    }

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
    @Override
    public List<Map<String, Object>> listPrivateProduct(Map<String, Object> params) {
        return furnitureShopApiMapper.listPrivateProduct(params);
    }

    /**
     * @param params shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id查询店铺团队信息
     */
    @Override
    public Map<String, Object> getShopTeamMessage(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<>();
        // 查询店铺人员配置信息
        resultMap.put("staffingMessage", furnitureShopApiMapper.getShopStaffingMessage(params));
        // 查询各岗位详细信息
        resultMap.put("roleMessageList", furnitureShopApiMapper.listRoleMessageList(params));
        return resultMap;
    }

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
    @Override
    public int updateEmployeeMessage(Map<String, Object> params) {
        return furnitureShopApiMapper.updateEmployeeMessage(params);
    }

    /**
     * @param params shopId 店铺id
     *               employeeRole 用户角色
     *               employeeNumber 用户数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id和用户角色添加用户数量
     */
    @Override
    public int addEmployees(Map<String, Object> params) {
        int count = Integer.parseInt(params.get("employeeNumber").toString());
        String userCard = "RX-JJ-00";
        params.put("userCard", userCard);
        for (int i = 0; i < count; i++) {
            furnitureShopApiMapper.addEmployeesMessage(params);
        }
        return furnitureShopApiMapper.addEmployees(params);
    }

    /**
     * @param params shopId 店铺id
     *               licenseImg 营业执照
     *               permitImg 开户许可证
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新营业执照信息
     */
    @Override
    public int updateShopLicenseMessage(Map<String, Object> params) {
        return furnitureShopApiMapper.updateShopLicenseMessage(params);
    }

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
    @Override
    public int updateShopSealMessage(Map<String, Object> params) {
        return furnitureShopApiMapper.updateShopSealMessage(params);
    }

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
    @Override
    public int updateShopFinaceMessage(Map<String, Object> params) {
        return furnitureShopApiMapper.updateShopFinaceMessage(params);
    }

    /**
     * @param params shopId 店壳编号
     *               workAddress 办公地址
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺信息
     */
    @Override
    public int updateShopShellMessage(Map<String, Object> params) {
        int resultCode = -1;
        // 查询办公地址是否存在，存在即更新，否则新增
        Map<String,Object> resultMap = furnitureShopApiMapper.getShopAddressByShopShellId(params);
        if(null != resultMap){
            resultCode = furnitureShopApiMapper.updateShopShellMessage(params);
        } else {
            resultCode = furnitureShopApiMapper.addShopShellMessage(params);
        }
        return resultCode;
    }

    /**
     * @param params shopId 店铺id
     *               headImg 信息费
     *               HeadIDCardImg 风险费
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺加盟合同信息
     */
    @Override
    public int updateShopJoinContractMessage(Map<String, Object> params) {
        params.put("joinContract", params.get("headImg").toString());
        params.put("joinContractElse", params.get("HeadIDCardImg").toString());
        return furnitureShopApiMapper.updateShopJoinContractMessage(params);
    }

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
    @Override
    public int updateShopHouseContractMessage(Map<String, Object> params) {
        return furnitureShopApiMapper.updateShopHouseContractMessage(params);
    }

    /**
     * @param params shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-25
     * @功能描述 家具店铺：根据店铺id查询店铺擅长风格
     */
    @Override
//    @DataSource(name = "second")
    public List<Map<String, Object>> listShopStyleById(Map<String, Object> params) {
        return furnitureShopApiMapper.listShopStyleById(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型下的产品类型和类目之间的关系
     * @param params
     * @return 空对象
     */
    @Override
    public int edit_ShopSubjectMapping(Map<String, Object> params){
        return furnitureShopApiMapper.edit_ShopSubjectMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型下的产品类型和类目之间的关系
     * @param params
     * @return 空对象
     */
    @Override
    public int delete_ShopSubjectMapping(Map<String, Object> params){
        return furnitureShopApiMapper.delete_ShopSubjectMapping(params);
    }

    /**
     * @param params
     * @return 获取店铺分类
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺分类
     */
    @Override
    public List<Map<String, Object>> listShopSubjectAuxiliary(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopSubjectAuxiliary(params);
        for (int i = 0; i < result.size(); i ++) {
            Map<String, Object> param = new HashMap<>();
            param.put("ParentID", result.get(i).get("Sid"));
            result.get(i).put("Second", furnitureShopApiMapper.listShopSubjectAuxiliary1(param));
        }
        return result;
    }


    /**
     * @param params
     * @return 获取店铺类型下的产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    @Override
    public List<Map<String, Object>> listShopProduct(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopProduct(params);
        for (int i = 0; i < result.size(); i ++) {
            Map<String, Object> param = new HashMap<>();
            param.put("pi_Code", result.get(i).get("pi_Code"));
            result.get(i).put("ProductImage", furnitureShopApiMapper.list_ProductImage(param));
            result.get(i).put("Specification", furnitureShopApiMapper.list_ProductModelSpecification(param));
        }
        return result;
    }

    /**
     * @param params
     * @return 获取店铺类型下辅料产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    @Override
    public List<Map<String, Object>> listShopProductTechnology(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopProductTechnology(params);
        return result;
    }

    /**
     * @param params
     * @return 获取店铺类型下的产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    @Override
    public List<Map<String, Object>> listShopProductAuxiliary(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopProductAuxiliary(params);
        return result;
    }

    /**
     * @param params
     * @return 店铺产品辅料类别映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品辅料类别映射关系列表
     */
    @Override
    public List<Map<String, Object>> listShopSubjectAuxiliaryMapping(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopSubjectAuxiliaryMapping(params);
        return result;
    }

    /**
     * @param params
     * @return 店铺产品工艺类别映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品工艺类别映射关系列表
     */
    @Override
    public List<Map<String, Object>> listShopSubjectTechnologyMapping(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopSubjectTechnologyMapping(params);
        return result;
    }

    /**
     * @param params
     * @return 获取店铺类型下辅料产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    @Override
    public List<Map<String, Object>> listProductTechnology(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listProductTechnology(params);
        return result;
    }

    /**
     * @param params
     * @return 获取店铺类型下的产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下的产品
     */
    @Override
    public List<Map<String, Object>> listProductAuxiliary(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listProductAuxiliary(params);
        return result;
    }

    /**
     * @param params
     * @return 店铺产品辅料产品映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品辅料产品映射关系列表
     */
    @Override
    public List<Map<String, Object>> listShopProductAuxiliaryMapping(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopProductAuxiliaryMapping(params);
        return result;
    }

    /**
     * @param params
     * @return 店铺产品工艺产品映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品工艺产品映射关系列表
     */
    @Override
    public List<Map<String, Object>> listShopProductTechnologyMapping(Map<String, Object> params){
        List<Map<String, Object>> result = furnitureShopApiMapper.listShopProductTechnologyMapping(params);
        return result;
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺关联辅料类
     * @param params
     * @return 空对象
     */
    @Override
    public int edit_ShopSubjectAuxiliaryMapping(Map<String, Object> params){
        return furnitureShopApiMapper.edit_ShopSubjectAuxiliaryMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺关联辅料类
     * @param params
     * @return 空对象
     */
    @Override
    public int delete_ShopSubjectAuxiliaryMapping(Map<String, Object> params){
        return furnitureShopApiMapper.delete_ShopSubjectAuxiliaryMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺下工艺类关系
     * @param params
     * @return 空对象
     */
    @Override
    public int edit_ShopSubjectTechnologyMapping(Map<String, Object> params){
        return furnitureShopApiMapper.edit_ShopSubjectTechnologyMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺下工艺类关系
     * @param params
     * @return 空对象
     */
    @Override
    public int delete_ShopSubjectTechnologyMapping(Map<String, Object> params){
        return furnitureShopApiMapper.delete_ShopSubjectTechnologyMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型关联的产品对应的辅料
     * @param params
     * @return 空对象
     */
    @Override
    public int edit_ShopProductAuxiliaryMapping(Map<String, Object> params){
        return furnitureShopApiMapper.edit_ShopProductAuxiliaryMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺类型关联的产品对应的辅料
     * @param params
     * @return 空对象
     */
    @Override
    public int delete_ShopProductAuxiliaryMapping(Map<String, Object> params){
        return furnitureShopApiMapper.delete_ShopProductAuxiliaryMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型关联工艺关系
     * @param params
     * @return 空对象
     */
    @Override
    public int edit_ShopProductTechnologyMapping(Map<String, Object> params){
        return furnitureShopApiMapper.edit_ShopProductTechnologyMapping(params);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺类型关联工艺关系
     * @param params
     * @return 空对象
     */
    @Override
    public int delete_ShopProductTechnologyMapping(Map<String, Object> params){
        return furnitureShopApiMapper.delete_ShopProductTechnologyMapping(params);
    }

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
    @Override
    public int addFundMessage(Map<String, Object> params) {
        return furnitureShopApiMapper.addFundMessage(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019-04-16
     * @功能描述 获取加盟商加盟费及风险押金信息
     * @param params shopId 店壳id
     * @return 获取加盟商加盟费及风险押金信息
     */
    @Override
    public List<Map<String, Object>> listBusinessMoney(Map<String, Object> params) {
        return furnitureShopApiMapper.listBusinessMoney(params);
    }
}
