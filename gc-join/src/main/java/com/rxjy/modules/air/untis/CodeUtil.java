package com.rxjy.modules.air.untis;

import com.rxjy.common.exception.RRException;

/**
 * 生成固定模式编号工具类
 * @author liwd
 * @create 2018-11-29 18:46
 */
public class CodeUtil {

	/**
	 * 生成新的Code 编号
	 * @param code 无数据传递null或最新编号
	 * @param identification 编号开头标识
	 * @param prefix 无数据传递null 二段标识
	 * @param autoNumSize 最大位数，编号位数
	 * @return
	 * @Author liwd
	 * @Date 2018/11/29 18:56
	 */
	public static String makeCode(String code,String identification,String prefix,int autoNumSize){
		StringBuilder stringBuilder = new StringBuilder();
		//code == null 创建 code != null 增加
		if (code!=null){
			stringBuilder.append(code.substring(0,code.length() - autoNumSize));
			Integer integer = Integer.valueOf(code.substring(code.length() - autoNumSize));
			integer++;
			String auto = strFormat(autoNumSize, integer);
			stringBuilder.append(auto);
		}else{
			stringBuilder.append(identification);
			if(prefix != null){
				stringBuilder.append(prefix);
			}
			String auto = strFormat(autoNumSize, 1);
			stringBuilder.append(auto);
		}
		return stringBuilder.toString();
	}

	/**
	 * @Description  数字格式化补0
	 * @Param [length:字符串长度, num：补0数值]
	 * @return java.lang.String
	 * @Author liwd
	 * @Date 2018/11/29 19:11
	 **/
	public static String strFormat(int length,int num){
		String result ="";
		if (String.valueOf(num).length()<=length){
			//格式
			String f ="%0"+String.valueOf(length)+"d";
			result = String.format(f, num);
		}else {
			throw new RRException("参数传递错误",10000);
		}
		return result;
	}



}
