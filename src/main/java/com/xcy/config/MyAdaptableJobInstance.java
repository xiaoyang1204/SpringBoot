package com.xcy.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobInstance")
public class MyAdaptableJobInstance extends AdaptableJobFactory{
	
	//AutowireCapableBeanFactory 可以将一个对象添加到SpringIOC容器中,并完成该对象的注入
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	
	/**
	 * 该方法需要将实例化的任务对象手动的添加到SpringIOC容器中并且完成对象的注入
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object obj = super.createJobInstance(bundle);
		//将obj对象添加到Spring IO容器中,并完成注入
		this.autowireCapableBeanFactory.autowireBean(obj);
		return obj;
	}
}
