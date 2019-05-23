package com.rxjy.modules.kshop.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author 陈旭
 * @create 2018-05-28 16:34
 * 用于将美国时区日期转换为北京时间格式
 */

public class DateFormat {
	public static Date parseDateT(String str) {
		if ("null".equals(str)){
			return new Date();
		}
		try {
			String tzId = TimeZone.getDefault().getID();
			TimeZone tz = TimeZone.getTimeZone(tzId);
			SimpleDateFormat formatter  =  new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );
			formatter.setTimeZone(tz);
			String s1= String.valueOf(formatter.parse(str));
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
			Date date = sdf.parse(s1);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @创建人 岳耀栎
	 * @创建时间 2019-04-09
	 * @功能说明 时间戳转String类型时间
	 * @param timeInMillis 时间戳
	 * @return 时间
	 */
	public static String longParseDate(String timeInMillis) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(timeInMillis);
		Date date = new Date(lt);
		String res = simpleDateFormat.format(date);
		return res;
	}

	public static void main(String[] args){
		Calendar now = Calendar.getInstance();
		long longParseDate = now.getInstance().getTimeInMillis();

		longParseDate(longParseDate+"");
	}
}
