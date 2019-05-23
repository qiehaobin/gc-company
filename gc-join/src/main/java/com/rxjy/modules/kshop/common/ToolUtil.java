package com.rxjy.modules.kshop.common;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @创建人 陈旭
 * @创建时间 2018-05-15 13:22
 * @功能描述 目的用于封装一些关于字符，类的公共方法
 */

public class ToolUtil {
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/15
	 * @功能描述：判断字符是否为空
	 */
	public static boolean strNotIsEmpty(Object str) {
		if (str != null && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/15
	 * @功能描述：判断对象是否为空
	 */
	public static boolean objectNotIsEmpty(Object obj) {
		return !StringUtils.isEmpty(obj);
	}

	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/15
	 * @功能描述：判断BigDecimal值大于0
	 */
	public static boolean bigNotZero(Object big) {
		return big != null && new BigDecimal(big.toString()).compareTo(new BigDecimal(0)) == 1;
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/16
	 * @功能描述：判断两个BigDecimal值是否相等
	 */
	public static boolean bigEqualTo(BigDecimal b1,BigDecimal b2) {
		if(b1 == null || b2 == null) {
			return false;
		}
		return 0 == b1.compareTo(b2);
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/16
	 * @功能描述：判断两个BigDecimal值,值1是否大于值2
	 */
	public static boolean bigIsGreaterThan(BigDecimal b1,BigDecimal b2) {
		if(b1 == null || b2 == null) {
			return false;
		}
		return 1==b1.compareTo(b2);
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/16
	 * @功能描述：判断两个BigDecimal值,值1是否小于值2
	 */
	public static boolean bigIsLessThan(BigDecimal b1,BigDecimal b2) {
		if(b1 == null || b2 == null) {
			return false;
		}
		return -1==b1.compareTo(b2);
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/16
	 * @功能描述：判断两个BigDecimal值,值1是否大于等于值2
	 */
	public static boolean bigIsGreaterThanOrEqualTo(BigDecimal b1,BigDecimal b2) {
		if(b1 == null || b2 == null) {
			return false;
		}
		return 1==b1.compareTo(b2)|| 0==b1.compareTo(b2);
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/05/16
	 * @功能描述：判断两个BigDecimal值,值1是否小于等于值2
	 */
	public static boolean bigIslLessThanOrEqualTo(BigDecimal b1,BigDecimal b2) {
		if(b1 == null || b2 == null) {
			return false;
		}
		return -1==b1.compareTo(b2)|| 0==b1.compareTo(b2);
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/07/07
	 * @功能描述：将多个字符串转换为BigDecimal，并相加
	 */
	public static BigDecimal bigAddMagnitude(String... str) {
		BigDecimal result=new BigDecimal(0);
		try {
			for(String s:str){
				result=result.add(new BigDecimal(s));
			}
			return result;
		}catch (Exception e){
			return result;
		}
	}
	/**
	 * @创建人：陈旭
	 * @创建时间：2018/08/21
	 * @功能描述：判断BigDecimal值是否大于等于0
	 */
	public static boolean greaterThanOrEqualToZero(BigDecimal big) {
		if(big == null) {
			return false;
		}
		return 0==big.compareTo(new BigDecimal(0))|| 1==big.compareTo(new BigDecimal(0));
	}

    /**
     * @创建人：岳耀栎
     * @创建时间：2018/10/18
     * @功能描述：数组转arrayList
     */
    public static <E>  List<E> transferArrayToList(E[] array){
        List<E> transferedList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferedList.add(arr));
        return transferedList;
    }

    /**
     * @创建人：岳耀栎
     * @创建时间：2018/10/18
     * @功能描述：去除字符串首尾出现的某个字符.
     * @param source 源字符串.
     * @param element 需要去除的字符.
     * @return String.
     */
    public static String trimFirstAndLastChar(String source,char element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
            int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element) : source.length();
            source = source.substring(beginIndex, endIndex);
            beginIndexFlag = (source.indexOf(element) == 0);
            endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
        } while (beginIndexFlag || endIndexFlag);
        return source;
    }

}
