package com.xcy.common;

import java.util.Date;

import org.springframework.stereotype.Component;


/**
 * Scheduled定时任务
 * @author xingchongyang
 *
 */
//@Component
public class Scheduled {
	/**
	 * 定时任务方法
	 * Scheduled： 设置定时任务
	 * cron属性：cron表达式定时任务,触发式时间的一个字符串表法是
	 * 			秒：0-59 , 分钟：0-59  , 小时 0-23
	 * 			日：1-31  , 月：1-12 , 星期：1-7 (1代表周日)		
	 * 			* 表示每分钟  , ？表示占位符  , -表示范围  , ,表示和 
	 * 			/ 表示间隔 0/2(表示每两秒)
	 */
	@org.springframework.scheduling.annotation.Scheduled(cron ="0/2 49 17 * * ?")
	public void scheduledMethod() {
		System.out.println("定时器被触发" + new Date());
	}

}
