package com.xcy.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间工具类
 * @author xingchongyang
 *
 */
public class dateTimeUtil {
	
	public static String getTime() {
		Date date= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}
