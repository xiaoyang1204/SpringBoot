package com.xcy.common;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.xcy.pojo.User;
import com.xcy.service.UserService;

/**
 * 定义任务类
 * @author xingchongyang
 *
 */
public class Quartz implements Job{
	
	@Autowired
	private UserService userService;

	/**
	 * 任务被触发时执行的方法
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Executr"+ new Date());
		User user = new User();
		user.setUsername("王五");
		//this.userService.insertUser(user);
	}
}
