package com.xcy.config;
/**
 * Quaryz配置类
 * @author xingchongyang
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.xcy.common.Quartz;
@Configuration
public class QuaryzConfig {

	/**
	 * 1.创建Job对象
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		//关联我们自己的job类
		factory.setJobClass(Quartz.class);
		return factory;
	}
	
	/**
	 * 2.创建Trigger对象
	 *	 简单的Trigger
	 
	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		//关联JobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//该参数表示一个执行的毫秒数
		factory.setRepeatInterval(2000);
		//重复次数
		factory.setRepeatCount(5);
		return factory;
	}*/
	
	/**
	 * 创建一个Scheduler对象
	 
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		//关联Trigger
		factory.setTriggers(simpleTriggerFactoryBean.getObject());
		return factory;
	}*/
	
	/**
	 * Cron Trigger
	 */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//设置触发时间
		factory.setCronExpression("0/2 * * * * ?");
		return factory;
	}
	

	/**
	 * 创建一个Scheduler对象
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobInstance myAdaptableJobInstance) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		//关联Trigger
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		factory.setJobFactory(myAdaptableJobInstance);
		return factory;
	}
}
