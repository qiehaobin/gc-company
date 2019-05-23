package com.rxjy.modules.air.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.R;
import com.rxjy.common.utils.StringUtils;
import com.rxjy.modules.air.entity.*;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;
import com.rxjy.modules.air.service.*;
import com.rxjy.modules.air.service.AirShopShellService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("air/airShop")
/*
 *@Description 空调店铺控制器
 *@Author yangbin
 *@Date 2019年3月12日
 */
public class AirShopController {

    @Autowired
    private AirShopService airShopService;//空调店铺模板接口
    @Autowired
    private AirShopShellService airShopShellService;//空调店铺店壳接口
    @Autowired
    private PublicCategoryService publicCategoryService;//公共类别接口
    @Autowired
    private PublicSeriesService publicSeriesService;//公共型号接口
    @Autowired
    private AirShopProductService airShopProductService;
    @Autowired
    private PublicProductService publicProductService;//公共产品信息接口
    public static final Integer AIR_TYPE = 1;

    /**
     * 查询一段空调店铺模板列表
     *
     * @param airShopEntity 实体类
     * @return 空调店铺模板集合
     * id:模板编号
     * shopName：模板名称
     */
    @RequestMapping(value = "/getAirShopByCondition")
    public R getAirShopByCondition(AirShopEntity airShopEntity) {
        airShopEntity.setDelFlag("0");
        List<AirShopEntity> list = airShopService.getAirShopByCondition(airShopEntity);
        return R.ok().put("data", list);
    }

    /**
     * 新增空调店铺模板数据
     *
     * @param airShopEntity 空调店铺模板数据
     * @return
     */
    @RequestMapping(value = "/inertAirShop")
    public R inertAirShop(AirShopEntity airShopEntity) {

        try {

            Map<String, Object> maps = new HashMap<>();
            maps.put("shopTypeName", airShopEntity.getAirName());
            maps.put("shopCategory", 1);
            JSONObject mspJson = JSONUtil.parseFromMap(maps);

            //同步数据到六师
            String urlString = Global.getValue("bottomApi") + "/dbsplit/post";
            String tsip = HttpUtil.post(urlString, "type=" + 344 + "&param=" + mspJson);
            JSONObject jsonObject = JSONUtil.parseObj(tsip);
            String statusCode = jsonObject.getStr("statusCode");
            if ("1".equals(statusCode)) {
                return R.ok();
            } else {
                throw new Exception("底层失败");
            }


        } catch (Exception ex) {
            return R.error("保存失败,");
        }
    }

    /**
     * 同步空调店铺模板店面数据
     *
     * @param jsonStr 空调店铺模板店面数据
     * @return
     */
    @RequestMapping(value = "/synchroAirShopShell", method = RequestMethod.POST)
    public Map<String, Object> synchroAirShopShell(@RequestBody AirShopListDTO jsonStr) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        //得到json对象
        List<AirShopShellEntity> airShopShellEntities = jsonStr.getJsonStr();
        try {
            //保存到本部门数据库

            if (airShopShellEntities.size() > 0) {
                for (AirShopShellEntity a : airShopShellEntities) {
                    //已经存在的数据
                    List<AirShopShellEntity> haveAirShopShell = airShopShellService.getAirShopShellByCondition(a);
                    if (haveAirShopShell.size() > 0) {
                        airShopShellService.updateById(a);
                    } else {
                        airShopShellService.insert(a);
                    }
                }
            }
            responseMap.put("body", true);
            responseMap.put("statusCode", 1);
            responseMap.put("statusMsg", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("statusCode", 0);
            responseMap.put("statusMsg", "失败");
        }
        return responseMap;
    }

    /**
     * 同步空调店铺模板数据
     *
     * @param tcpShopTypeEntity 空调店铺模板数据
     * @return
     */
    @RequestMapping(value = "/synchroAirShop", method = RequestMethod.POST)
    public Map<String, Object> synchroAirShop(@RequestBody TcpShopTypeEntity tcpShopTypeEntity) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        AirShopEntity airShopEntity = new AirShopEntity();
        airShopEntity.setId(tcpShopTypeEntity.getId());//店面编号
        airShopEntity.setAirName(tcpShopTypeEntity.getShopTypeName());//店面主键
        airShopEntity.setDelFlag(tcpShopTypeEntity.getDelFlag());//是否删除
        airShopEntity.setSearchKey(tcpShopTypeEntity.getId());

        //修改时间为当前时间
        airShopEntity.setUpdateDate(DateTime.now());
        try {
            int result = 0;
            //已经存在的数据
            List<AirShopEntity> haveAirShop = airShopService.getAirShopByCondition(airShopEntity);

            if (haveAirShop.size() > 0) {

                airShopService.updateById(airShopEntity);
            } else {
                //创建时间为当前时间
                airShopEntity.setCreateDate(DateTime.now());
                //保存到本部门数据库
                airShopService.insertAirShop(airShopEntity);
            }
            responseMap.put("body", result);
            responseMap.put("statusCode", 1);
            responseMap.put("statusMsg", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("statusCode", 0);
            responseMap.put("statusMsg", "失败");
        }
        return responseMap;
    }

    /**
     * 根据地区编号得到店铺模板店面开店数量
     *
     * @param airShopShellEntity
     * @return 店铺模板店面开店数量集合
     * airName 模板名称
     * shopTypeId 模板编号
     * shopCount 店铺总数量
     * openShopCount 已开店铺
     * noShopCount 未开店铺
     */
    @RequestMapping(value = "/getAirShopShellCountByCityId")
    public R getAirShopShellCountByCityId(AirShopShellEntity airShopShellEntity) {
        List<AirShopShellEntity> list = airShopShellService.getAirShopShellCountByCityId(airShopShellEntity);
        return R.ok().put("data", list);
    }

    /**
     * 同步数据库与从客户端提交的AirShopProduct信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/operateAirShopProduct")
    public R operateAirShopProduct(@RequestBody AirShopListDTO airShopListDTO) {
        try {
            AirShopProductEntity AirShopProduct = new AirShopProductEntity();
            AirShopProduct.setShopId(airShopListDTO.getShopId());
            //删除指定品牌id 的所有记录
            airShopProductService.updateAirshopProductState(AirShopProduct);
            List<AirShopProductEntity> airShopProductentitis = airShopListDTO.getAirShopProductEntitis();
            for (int i = 0; i < airShopProductentitis.size(); i++) {
                String s = new String();
                //创建时间为当前时间
                airShopProductentitis.get(i).setCreateDate(DateTime.now());
                //修改时间为当前时间ankouha
                airShopProductentitis.get(i).setUpdateDate(DateTime.now());
                //设置状态为0   更新状态
                airShopProductentitis.get(i).setDelFlag(0);
                airShopProductService.saveAirshopProductState(airShopProductentitis.get(i));
            }
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }

    }

    /**
     * 展示指定shop_id的空调分类型号商品有效信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getAirShopProduct", method = RequestMethod.GET)
    public R getAirShopProduct(AirShopProductEntity airShopProductEntity) {
        try {
            List<AirShopProductEntity> airShopProductEntityList = airShopProductService.getAirShopProduct(airShopProductEntity);
            return R.ok().put("body", airShopProductEntityList);
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 根据条件查询空调店铺店面信息
     *
     * @param airShopShellEntity
     * @return 空调店铺店面信息实体
     * id 店面编号
     * shopName 店面名称
     * shopStage 店面阶段
     * cityId 地区编号
     */
    @RequestMapping(value = "getAirShopShellMsgByCondition")
    public R getAirShopShellMsgByCondition(AirShopShellEntity airShopShellEntity) {
        List<AirShopShellEntity> list = airShopShellService.getAirShopShellByCondition(airShopShellEntity);

        return R.ok().put("body", list);
    }

    /**
     * 店铺模板店面地区开店数量
     *
     * @return 店铺模板店面开店数量集合
     * cityId 城市编号
     * shopCount 店铺总数量
     * openShopCount 已开店铺
     * noShopCount 未开店铺
     */
    @RequestMapping(value = "getAirCityShellCount")
    public R getAirCityShellCount() {
        List<AirShopShellEntity> list = airShopShellService.getAirCityShellCount();
        return R.ok().put("body", list);

    }

    /**
     * 批量添加公共类别信息
     *
     * @param airShopListDTO 公共类别信息
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "insertPublicCategory")
    public R insertPublicCategory(@RequestBody AirShopListDTO airShopListDTO) {
        List<PublicCategoryEntity> publicCategoryEntities = airShopListDTO.getPublicCategoryEntities();
        if (publicCategoryEntities != null && publicCategoryEntities.size() > 0) {
            for (PublicCategoryEntity a : publicCategoryEntities) {
                a.setCreateTime(DateTime.now());
                a.setUpdateTime(DateTime.now());
                a.setDelFlag("0");
                if (a.getId() > 0) {
                    publicCategoryService.updateById(a);
                } else {
                    publicCategoryService.insert(a);
                }

            }
        }
        return R.ok();
    }

    /**
     * 批量添加公共型号信息
     *
     * @param airShopListDTO 公共型号信息
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "insertPublicSeries")
    public R insertPublicSeries(@RequestBody AirShopListDTO airShopListDTO) {
        List<PublicSeriesEntity> publicSeriesEntities = airShopListDTO.getPublicSeriesEntities();
        if (publicSeriesEntities != null && publicSeriesEntities.size() > 0) {
            for (PublicSeriesEntity a : publicSeriesEntities) {
                a.setCreateTime(DateTime.now());
                a.setUpdateTime(DateTime.now());
                a.setDelFlag("0");
                if (a.getId() > 0) {
                    publicSeriesService.updateById(a);
                } else {
                    publicSeriesService.insert(a);
                }

            }
        }
        return R.ok();
    }

    /**
     * 添加产品信息
     *
     * @param publicProductEntity 产品信息
     * @return
     */
    @RequestMapping(value = "insertPublicProduct")
    public R insertPublicProduct(PublicProductEntity publicProductEntity) {
        publicProductEntity.setDelFlag("0");
        publicProductEntity.setCreateTime(DateTime.now());
        publicProductEntity.setUpdateTime(DateTime.now());
        publicProductService.insert(publicProductEntity);
        return R.ok();
    }

    /**
     * 根据条件公共类别信息
     *
     * @param publicCategoryEntity 公共类别信息
     * @return 公共类别信息集合
     * categoryName 类别名称
     * id  类别编号
     * categoryType 类别类型
     */
    @RequestMapping(value = "getAirPublicCategoryByCondition")
    public R getAirPublicCategoryByCondition(PublicCategoryEntity publicCategoryEntity) {
        List<PublicCategoryEntity> list = publicCategoryService.getPublicCategoryByCondition(publicCategoryEntity);
        return R.ok().put("body", list);
    }

    /**
     * 根据条件修改公共型号信息
     *
     * @param publicSeriesEntity 公共型号信息
     * @return
     */
    @RequestMapping(value = "updatePublicSeriesByCondition")
    public R updatePublicSeriesByCondition(PublicSeriesEntity publicSeriesEntity) {

        //修改当前型号信息
        publicSeriesEntity.setUpdateTime(DateTime.now());
        publicSeriesService.updateById(publicSeriesEntity);
        //如果删除当前型号 则对应的产品也删除
        if (publicSeriesEntity.getDelFlag() != "0") {
            //公共产品信息
            PublicProductEntity publicProductEntity = new PublicProductEntity();
            publicProductEntity.setDelFlag("1");
            publicProductEntity.setSeriesId(publicSeriesEntity.getId());
            publicProductService.updateAirProductByCondition(publicProductEntity);

        } else//如果当前型号变更，则更改其名称
        {
            //公共产品信息
            PublicProductEntity publicProductEntity = new PublicProductEntity();

            publicProductEntity.setSeriesId(publicSeriesEntity.getId());
            publicProductEntity.setSeriesName(publicSeriesEntity.getSeriesName());
            publicProductService.updateAirProductByCondition(publicProductEntity);
        }
        return R.ok();
    }

    /**
     * 根据条件修改公共类别信息
     *
     * @param publicCategoryEntity 公共类别信息
     * @return
     */
    @RequestMapping(value = "updatePublicCategoryByCondition")
    public R updatePublicCategoryByCondition(PublicCategoryEntity publicCategoryEntity) {


        PublicCategoryEntity publicCategory = new PublicCategoryEntity();
        publicCategory.setId(publicCategoryEntity.getId());
        publicCategory.setUpdateTime(DateTime.now());
        publicCategory.setDelFlag(publicCategoryEntity.getDelFlag());
        publicCategory.setCategoryName(publicCategoryEntity.getCategoryName());
        //修改当前类别信息


        publicCategoryService.updateById(publicCategory);
        //如果删除当前类别 则对应的产品也删除
        if (publicCategoryEntity.getDelFlag() != "0") {
            //公共型号信息
            PublicSeriesEntity publicSeriesEntity = new PublicSeriesEntity();
            publicSeriesEntity.setDelFlag("1");
            publicSeriesEntity.setCategoryTypeId(publicCategoryEntity.getId());
            publicSeriesService.updatePublicSeriesByCondition(publicSeriesEntity);
            //公共产品信息
            PublicProductEntity publicProductEntity = new PublicProductEntity();
            publicProductEntity.setDelFlag("1");
            publicProductEntity.setCategoryId(publicCategoryEntity.getId());
            publicProductService.updateAirProductByCondition(publicProductEntity);
        } else//如果当前类别变更，则更改其名称
        {
            //公共产品信息
            PublicProductEntity publicProductEntity = new PublicProductEntity();

            publicProductEntity.setCategoryId(publicCategoryEntity.getId());
            publicProductEntity.setCategoryName(publicCategoryEntity.getCategoryName());
            publicProductService.updateAirProductByCondition(publicProductEntity);

        }
        return R.ok();
    }

    /**
     * 根据条件查询空调产品信息
     *
     * @param publicProductEntity 空调产品信息
     * @return 空调产品信息
     * id 产品主键
     * productName 产品名称
     * categoryId 类别编号
     * categoryName 类别名称
     * seriesId 型号编号
     * seriesName 型号名称
     * unit 单位
     * price 金额
     * mainImg 主图
     * remark 备注
     * productType 产品类型：1、空调产品
     */
    @RequestMapping(value = "getAirProductByCondition")
    public R getAirProductByCondition(PublicProductEntity publicProductEntity) {
        List<PublicProductEntity> list = publicProductService.getAirProductByCondition(publicProductEntity);
        return R.ok().put("body", list);
    }

    /**
     * 查询店铺店面信息
     *
     * @return cityId 城市编号
     * shopStage 阶段
     * cityName 城市名称
     * airName 店铺模板名称
     */
    @RequestMapping(value = "getAirCityShellMsg")
    public R getAirCityShellMsg() {
        List<AirShopShellEntity> list = airShopShellService.getAirCityShellMsg();
        return R.ok().put("body", list);

    }
    /**
     * 查询店铺店面人员名称信息
     *
     * @return cityId 城市编号
     * shopStage 阶段
     * cityName 城市名称
     * airName 店铺模板名称、
     * airPeopleName 人员姓名
     */
    @RequestMapping(value = "getAirCityShellPeopleMsg")
    public R getAirCityShellPeopleMsg() {
        List<AirShopShellEntity> list = airShopShellService.getAirCityShellPeopleMsg();
        return R.ok().put("body", list);

    }

    /**
     * 查询所有类型对应的型号与产品数量
     *
     * @return id 类型编号
     * categoryName 类型名称
     * seriesCount 型号数量
     * productCount 产品数量
     */
    @RequestMapping(value = "getAirPublicCategoryStatistics")
    public R getAirPublicCategoryStatistics() {
        List<PublicCategoryEntity> list = publicCategoryService.getAirPublicCategoryStatistics();
        return R.ok().put("body", list);
    }


    /**
     * 查询所有类型对应的型号与产品数量
     *
     * @return id 型号编号
     * seriesName 类型名称
     * productCount 产品数量
     */
    @RequestMapping(value = "getAirCategorySeriesByCondition")
    public R getAirCategorySeriesByCondition(PublicSeriesEntity publicSeriesEntity) {
        List<PublicSeriesEntity> list = publicSeriesService.getAirCategorySeriesByCondition(publicSeriesEntity);
        return R.ok().put("body", list);
    }

    /**
     * 查询所有的分类
     *
     * @return categoryType   分类类型
     * categoryName   分类名称
     */
    @RequestMapping(value = "getCatgoryList")
    public R getCatgoryList(AirShopEntity airShopEntity) {
        List<PublicCategoryEntity> list = publicCategoryService.getCatgoryList(airShopEntity);
        return R.ok().put("body", list);
    }

    /**
     * 通过查询指定categoryId的所有系列名称
     * categoryTypeId  类别类型
     *
     * @return categoryTypeId 对应的分类类型
     * seriesName   系列名称
     * seriesType  系列类型
     */
    @RequestMapping(value = "getPublicSeriesListBycategoryTypeId")
    public R getPublicSeriesListBycategoryTypeId(AirShopProductEntity airShopProductEntity) {
        List<PublicSeriesEntity> list = publicSeriesService.getPublicSeriesListBycategoryTypeId(airShopProductEntity);
        return R.ok().put("body", list);
    }

    /**
     * 根据条件查询空调人员的产品信息
     *
     * @param airPeopleEntity 条件
     * @return id 产品主键
     * productName 产品名称
     * categoryId 类别编号
     * categoryName 类别名称
     * seriesId 型号编号
     * seriesName 型号名称
     * unit 单位
     * price 金额
     * mainImg 主图
     * remark 备注
     * productType 产品类型：1、空调产品
     * airName 品牌名称
     */
    @RequestMapping("/getAirPeopleProduceByCondition")
    public R getAirPeopleProduceByCondition(AirPeopleEntity airPeopleEntity) {
        List<PublicProductEntity> publicProductEntities = publicProductService.getAirPeopleProduceByCondition(airPeopleEntity);
        return R.ok().put("body", publicProductEntities);
    }

    /**
     * 根据条件查询空调人员的产品信息
     *
     * @param airShopEntity 条件
     * @return id 产品主键
     * productName 产品名称
     * categoryId 类别编号
     * categoryName 类别名称
     * seriesId 型号编号
     * seriesName 型号名称
     * unit 单位
     * price 金额
     * mainImg 主图
     * remark 备注
     * productType 产品类型：1、空调产品
     * airName 品牌名称
     */
    @RequestMapping("/getAirShopProductByCondition")
    public R getAirShopProductByCondition(AirShopEntity airShopEntity) {
        List<PublicProductEntity> airShopProducts = publicProductService.getAirShopProductByCondition(airShopEntity);
        return R.ok().put("body", airShopProducts);
    }

    /**
     * 通过seriesId,category_id查询对应的商品信息
     * seriesId    型号类型
     *
     * @return productId  商品类型
     * productName  商品名称
     */
    @RequestMapping(value = "getAirShopProduceByCondition")
    public R getAirShopProduceByCondition(AirShopProductEntity airShopProductEntity) {
        List<PublicProductEntity> list = publicProductService.getPublicProductListBySeriesIdsCategoryIdShopId(airShopProductEntity);
        return R.ok().put("body", list);
    }


    /**
     * 根据条件查询品牌对应的类型信息
     *
     * @param airShopProductEntity
     * @return
     */
    @RequestMapping("/getAirShopCategoryByCondition")
    public R getAirShopCategoryByCondition(AirShopProductEntity airShopProductEntity) {
        List<PublicCategoryEntity> publicCategoryEntities = publicCategoryService.getAirShopCategoryByCondition(airShopProductEntity);
        return R.ok().put("body", publicCategoryEntities);
    }

    /**
     * 根据条件查询品牌对应的型号信息
     *
     * @param airShopProductEntity
     * @return
     */
    @RequestMapping("/getAirShopSeriesByCondition")
    public R getAirShopSeriesByCondition(AirShopProductEntity airShopProductEntity) {
        List<PublicSeriesEntity> publicSeriesEntities = publicSeriesService.getAirShopSeriesByCondition(airShopProductEntity);
        return R.ok().put("body", publicSeriesEntities);
    }

    /**
     * 添加品牌对应的类型和系列信息
     *
     * @param airShopListDTO
     * @return
     */
    @RequestMapping("/insertAirShopProduce")
    public R insertAirShopProduce(@RequestBody AirShopListDTO airShopListDTO) {
        //删除品牌下的类型和系列信息
        AirShopProductEntity airShopProduct = new AirShopProductEntity();
        airShopProduct.setShopId(airShopListDTO.getShopId());
        airShopProductService.updateAirshopProductState(airShopProduct);
        airShopProductService.deleteAirShopProduce(airShopProduct);
        //类型和系列信息
        List<AirShopProductEntity> airShopProductEntities = airShopListDTO.getAirShopProductEntitis();
        if (airShopProductEntities.size() > 0) {
            for (AirShopProductEntity a : airShopProductEntities) {
                a.setCreateDate(DateTime.now());
                a.setDelFlag(0);
                airShopProductService.insert(a);
            }
        }
        return R.ok();
    }

    /**
     * 根据条件查询空调店铺店壳信息
     * @param airShopShellEntity
     * @return
     */
    @RequestMapping("/getAirShopShellByCondition")
    public R getAirShopShellByCondition(AirShopShellEntity airShopShellEntity) {
        List<AirShopShellEntity> list=airShopShellService.getAirShopShellByCondition(airShopShellEntity);
        return R.ok().put("data",list);
    }
    /**
     * 根据条件获取空调店铺类别型号信息
     * @param airShopEntity
     * @return
     */
    @RequestMapping("/getAirShopCategorySeriesByCondition")
    public  R getAirShopCategorySeriesByCondition(AirShopEntity airShopEntity)
    {
        List<PublicProductEntity> publicProductEntities= publicProductService.getAirShopSeriesByCondition(airShopEntity);
        return R.ok().put("body",publicProductEntities);
    }

    /**
     * 查询所有的空调信息
     */
    @RequestMapping("/getAllAirShop")
    public R getAllAirShop(){
        List<AirShopEntity> list=airShopService.getAllAirShop();
        return R.ok().put("data",list);
    }

    /**
     * @author zhangzhoubin
     * @date 2019/4/2 17:23
     * @param[airShopShellEntity]
     * @return com.rxjy.common.utils.R
     * @describe  查询个人店铺左侧列表
     */
    @ApiOperation("查询个人店铺左侧列表")
    @GetMapping("/getPersonalshopleftlist")
    public R getPersonalshopleftlist( String aid ) {
        List<Map> list=airShopShellService.getPersonalshopleftlist(aid);
        return R.ok().put("data",list);
    }

    /**
     * @author zhangzhoubin
     * @date 2019/4/2 17:26
     * @param[aid]
     * @return com.rxjy.common.utils.R
     * @describe 查询个人店铺二段经营数据
     */
    @ApiOperation("查询个人店铺二段经营产品数据")
    @GetMapping("/getPersonalshopManagementlist")
    public R getPersonalshopManagementlist( String aid ) {
        List<Map> list=airShopShellService.getPersonalshopManagementlist(aid);
        return R.ok().put("data",list);
    }

    /**
     * @author zhangzhoubin
     * @date 2019/4/3 16:44
     * @param[aid]
     * @return com.rxjy.common.utils.R
     * @describe
     */
    @ApiOperation("查询个人店铺二段经营主营数据")
    @GetMapping("/getPersonalshopmaincamplist")
    public R getPersonalshopmaincamplist( String aid ) {
        Map list=airShopShellService.getPersonalshopmaincamplist(aid);
        return R.ok(list);
    }

    /**
     * @author zhangzhoubin
     * @date 2019/4/3 19:04
     * @param[aid]
     * @return com.rxjy.common.utils.R
     * @describe
     */
    @ApiOperation("查询个人店铺二段人事城标二段三段")
    @GetMapping("/getPersonalshoppeoplelist")
    public R getPersonalshoppeoplelist( String aid ) {
        Map list=airShopShellService.getPersonalshoppeoplelist(aid);
        return R.ok(list);
    }

    /**
     * @author zhangzhoubin
     * @date 2019/4/4 14:05
     * @param[areaId, cityid, address]
     * @return com.rxjy.common.utils.R
     * @describe  保存个人铺人事城标二段三段
     */
    @GetMapping("/updatePersonnelmatterscitystandard")
    public R updatePersonnelmatterscitystandard(int areaId,int cityid,String address,String aid){
         int data=airShopShellService.updatePersonnelmatterscitystandard(areaId,cityid,address,aid);
         if (data>0){
             return R.ok("保存成功");
         }else {
             return R.error("保存失败");
         }
    }

     /**
      * @author zhangzhoubin
      * @date 2019/4/9 14:53
      * @param []
      * @return com.rxjy.common.utils.R
      * @describe 保存个人铺经营我的三段信息
      */
     @PostMapping("/saveair_shop_picture")
     public R saveair_shop_picture(@RequestBody AirShopPictureEntity airShopPictureEntity){
         int data=airShopService.saveair_shop_picture(airShopPictureEntity);
         if (data>0){
             return R.ok("保存成功");
         }else {
             return R.error("保存失败");
         }
     }

     /**
      * @author zhangzhoubin
      * @date 2019/4/9 16:54
      * @param[]
      * @return com.rxjy.common.utils.R
      * @describe 查询人事三段信息
      */
    @GetMapping("/selectPersonnelcertification")
    public R selectPersonnelcertification(String aid){
        Map map=new HashMap();
        if (!StringUtils.isEmpty(aid)){
             map=airShopService.selectPersonnelcertification(aid);
        }
        return R.ok(map);
    }

    /**
     * @author zhangzhoubin
     * @date 2019/4/9 18:38
     * @param []
     * @return com.rxjy.common.utils.R
     * @describe  修改人事三段信息
     */
    @PostMapping("/updatePersonnelcertification")
    public R updatePersonnelcertification(PersonnelcertificationEntity personnelcertificationEntity){
        int data=airShopService.updatePersonnelcertification(personnelcertificationEntity);
        if (data>0){
            return R.ok("保存成功");
        }else {
            return R.error("保存失败");
        }
    }
    /**
     * @author zhangzhoubin
     * @date 2019/4/9 19:44
     * @param[]
     * @return com.rxjy.common.utils.R
     * @describe 查询个人铺经营我的三段信息
     */
    @GetMapping("/selectair_shop_picture")
    public R selectair_shop_picture(String aid){
        List<Map> mapList=airShopService.selectair_shop_picture(aid);
      return R.ok().put("data",mapList);
    }

    @GetMapping("/updateair_people_infostage")
    public R updateair_people_infostage(String attr_file_url){
        int data=airShopService.updateair_people_infostage(attr_file_url);
        if (data>0){
            return R.ok("修改成功");
        }else {
            return R.error("修改失败");
        }
    }

































}
