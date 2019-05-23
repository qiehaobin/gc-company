package com.rxjy.modules.air.controller;

import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.R;
import com.rxjy.common.utils.StringUtils;
import com.rxjy.modules.air.service.PublicCategoryService;
import com.rxjy.modules.air.untis.DesUtil;
import com.rxjy.modules.air.untis.TokenJsonToObj;
import com.rxjy.modules.air.untis.WPSLoginUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 登陆用户信息
 */
@RestController
@RequestMapping("air/loginUser")
public class LoginUserController {


   // public static final String TOKEN_KEY = Global.getValue("tokenKey");   //Tokenkey

    /*@RequestMapping("/getLoginUser")
    public R getLoginUser(String jwt){
        if (StringUtils.isBlank(jwt)) {
            return R.error().put("code","-1").put("msg","获取登陆用户失败");
        }
        String msg = null;
        try {
            msg = java.net.URLDecoder.decode(DesUtil.decrypt(jwt,TOKEN_KEY), "utf-8");
            WPSLoginUser loginUser = TokenJsonToObj.jsonToUser(msg);
            return R.ok().put("code","0").put("data",loginUser);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code","-1").put("msg","获取登陆用户失败");
        }
    }*/

}
