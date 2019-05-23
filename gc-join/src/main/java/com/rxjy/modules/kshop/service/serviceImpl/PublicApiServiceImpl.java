package com.rxjy.modules.kshop.service.serviceImpl;

import com.rxjy.modules.kshop.service.PublicApiService;
import com.rxjy.modules.kshop.dao.PublicApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @创建人 岳耀栎
 * @创建时间 2019/03/25
 * @功能描述 家弱公用：业务逻辑处理类
 */
@Service
public class PublicApiServiceImpl implements PublicApiService {

    @Autowired
    private PublicApiDao publicApiMapper;

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
    @Override
    public Map<String, Object> getUserInfoByRole(Map<String, Object> params,HttpServletResponse response) {
        Map<String,Object> resultMap  = new HashMap<>();
        String cookie = "";
        try {
            cookie = URLEncoder.encode(resultMap.toString(), "UTF-8").toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Cookie cook = new Cookie("userInfo", cookie);
        cook.setMaxAge(1 * 60 * 60 * 1000);
        response.addCookie(cook);
        return null;
    }

    /**
     * @param params shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-26
     * @功能描述 家具店铺：根据店铺id更新擅长风格
     */
    @Override
    public int updateShopStyleById(Map<String, Object> params) {
        if(null != params.get("style")){
            List<String> styleList = (List<String>) params.get("style");
            String a = null;
            for(int i = 0; i<styleList.size();i++){
                a = a+","+styleList.get(i);
            }
            a = a.substring(5);
            params.put("style",a);
        }
        String AreaCovered = "";
        if(null != params.get("areaCovered")){
            List areaList = Arrays.asList(params.get("areaCovered").toString().split(","));
            for(int i = 0; i< areaList.size(); i++){
                AreaCovered = AreaCovered +","+areaList.get(i);
            }
            AreaCovered = AreaCovered.substring(2,AreaCovered.length()-1);
        }
        params.put("AreaCovered",AreaCovered);

        return publicApiMapper.updateShopStyleById(params);
    }


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
    @Override
    public Map<String, Object> getUserInfo(Map<String, Object> params) {
//        Map<String,Object> resultMap  = new HashMap<>();

        return publicApiMapper.getUserInfo(params);
    }

    /**
     * @param params orgId 公司id
     *               rwdid 项目单号
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-26
     * @功能描述 家具店铺：项目接单
     */
    @Override
    public int updateOrderByOrgId(Map<String, Object> params) {
        return publicApiMapper.updateOrderByOrgId(params);
    }
}
