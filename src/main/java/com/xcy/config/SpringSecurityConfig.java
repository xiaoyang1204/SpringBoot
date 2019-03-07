package com.xcy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 使用 SpringSecurity 有很多好处：
 * ①输入一个需要登录验证的url，先跳转到登录界面，登录成功后，立即跳转到刚才请求的url
 * @author linhongcun
 *
 */

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启 SpringSecurity注解
//1.继承WebSecurityConfigurerAdapter适配器
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// 2.重写configure(AuthenticationManagerBuilder)、configure(HttpSecurity)，快捷键Alt+Shift+S
	@Override
	public void configure(AuthenticationManagerBuilder  auth) throws Exception {
		 auth.inMemoryAuthentication()
         .withUser("cun")// 用户名
         .password("123")// 用户密码
         .roles("USER");// 认证后必须加入一个角色，这里随便设为USER
	}

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().cors().disable().headers().disable()// 一般设置去掉，否则经常报错
	                .authorizeRequests()

	                .anyRequest()
	                .authenticated()// 其他 url 需要身份认证

	                .and()
	                .formLogin()  //开启登录
	                .loginPage("/login")// 指定登录请求的 url
	                .defaultSuccessUrl("/main") // 登录成功后的 url
	                .permitAll()

	                .and()
	                .logout()  //开启注销
	                .logoutUrl("/logout") //指定注销请求的 url (default is "/logout"). 
	                .logoutSuccessUrl("/login") // 注销成功后的 url
	                .permitAll();
	    }

	
}
