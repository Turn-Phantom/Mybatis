package com.li.mybatis5.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_DateExchange {
	//日期格式转换
	public String getExchangeDate (Date date) {
		if(date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
			String newdate = sdf.format(date);
			return newdate;
		}
		return null;		
	}
	//判断性别
	public String getSexFormat(int sex) {
		if(sex == 0) {
			return "女";
		}
		else
			return "男";
	}
}
