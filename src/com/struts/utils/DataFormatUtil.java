package com.struts.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatUtil {

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	//日期转字符串
	public static String formatToString(Date date){
		return sdf.format(date);
	}
	
	//字符串转日期
	public static Date parseStringToDate(String date){
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
