package com.rxjy.modules.air.untis;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * 解密用户
 *
 * @author Administrator
 * @create 2018-12-08 15:53
 */

public class TokenJsonToObj {

	/**
	 * 用户字符串转对象
	 * @return
	 */
	public static WPSLoginUser userStrToUser(String userStr){
		WPSLoginUser user = new WPSLoginUser();
		if(StringUtils.isNotBlank(userStr)){


			//json对象
			JSONObject jsonObj = JSONObject.parseObject(userStr);
			Object cardNumber = jsonObj.get("cardNumber");
			Object password = jsonObj.get("password");
			Object dq_name=jsonObj.get("dq_name");
			Object xinming = jsonObj.get("xinming");
			Object bumenId =jsonObj.get("bumenId");
			Object bumenName = jsonObj.get("bumenName");
			Object zhiwuId = jsonObj.get("zhiwuId");
			Object zhiwuName = jsonObj.get("zhiwuName");
			Object juese = jsonObj.get("juese");
			Object juesename = jsonObj.get("juesename");
			Object touxiang = jsonObj.get("touxiang");
			Object u_diqu = jsonObj.get("u_diqu");
			Object flag = jsonObj.get("flag");
			if(cardNumber!=null){
				user.setCardNumber(cardNumber.toString());
			}
			if(password!=null){user.setPassword(password.toString());user.setCiphertext(password.toString());}
			if(dq_name!=null){user.setDq_name(dq_name.toString());}
			if(xinming!=null){user.setXinming(xinming.toString());}
			if(bumenId!=null&&!bumenId.toString().equals("")){user.setBumenId(Integer.parseInt(bumenId.toString()));}
			if(bumenName!=null){user.setBumenName(bumenName.toString());}
			if(zhiwuId!=null&&!zhiwuId.toString().equals("")){user.setZhiwuId(Integer.parseInt(zhiwuId.toString()));}
			if(zhiwuName!=null){user.setZhiwuName(zhiwuName.toString());}
			if(juese!=null&&!juese.toString().equals("")){user.setJuese(Integer.parseInt(juese.toString()));}
			if(juesename!=null){user.setJuesename(juesename.toString());}
			if(touxiang!=null){user.setTouxiang(touxiang.toString());}
			if(u_diqu!=null&&!u_diqu.toString().equals("")){user.setU_diqu(u_diqu.toString());}
			if(flag!=null&&!flag.toString().equals("")){user.setFlag(Integer.parseInt(flag.toString()));}
		}

		return user;
	}

	/**
	 *
	 * 功能描述:用户json字符串转换为用户对象
	 *
	 * @param:
	 * @return:
	 * @auther: xsk
	 * @date: 2018/12/8 15:54
	 */
	public static WPSLoginUser jsonToUser(String jsonStr){
		WPSLoginUser user = new WPSLoginUser();
		if(StringUtils.isNotBlank(jsonStr)){



			//json对象
			JSONObject jsonObj = JSONObject.parseObject(jsonStr);
			Object cardNumber = jsonObj.get("u_kahao");
			Object password = jsonObj.get("u_passWord");
			Object dq_name=jsonObj.get("dq_name");
			Object xinming = jsonObj.get("xinming");
			Object bumenId =jsonObj.get("bumenId");
			Object bumenName = jsonObj.get("bumenName");
			Object zhiwuId = jsonObj.get("zhiwuId");
			Object zhiwuName = jsonObj.get("zhiwuName");
			Object juese = jsonObj.get("juese");
			Object juesename = jsonObj.get("juesename");
			Object touxiang = jsonObj.get("touxiang");
			Object u_diqu = jsonObj.get("u_diqu");
			Object flag = jsonObj.get("flag");
			if(cardNumber!=null){
				user.setCardNumber(cardNumber.toString());
			}
			if(password!=null){user.setPassword(password.toString());user.setCiphertext(password.toString());}
			if(dq_name!=null){user.setDq_name(dq_name.toString());}
			if(xinming!=null){user.setXinming(xinming.toString());}
			if(bumenId!=null&&!bumenId.toString().equals("")){user.setBumenId(Integer.parseInt(bumenId.toString()));}
			if(bumenName!=null){user.setBumenName(bumenName.toString());}
			if(zhiwuId!=null&&!zhiwuId.toString().equals("")){user.setZhiwuId(Integer.parseInt(zhiwuId.toString()));}
			if(zhiwuName!=null){user.setZhiwuName(zhiwuName.toString());}
			if(juese!=null&&!juese.toString().equals("")){user.setJuese(Integer.parseInt(juese.toString()));}
			if(juesename!=null){user.setJuesename(juesename.toString());}
			if(touxiang!=null){user.setTouxiang(touxiang.toString());}
			if(u_diqu!=null&&!u_diqu.toString().equals("")){user.setU_diqu(u_diqu.toString());}
			if(flag!=null&&!flag.toString().equals("")){user.setFlag(Integer.parseInt(flag.toString()));}
		}
		return user;
	}
}
