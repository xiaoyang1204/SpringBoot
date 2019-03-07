package com.xcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


//扫描所有需要的包，包含一些自用的工具类包所在的路径
//@ComponentScan(basePackages= {"com.xcy.*"})
//这里是扫描dao接口的包用于识别mybatis
//@MapperScan(basePackages="com.xcy.mapper")
//开始定时任务的注解
//@EnableScheduling
@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("");
		System.out.println("(♥◠‿◠)ﾉﾞ  后台管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
	}
}
