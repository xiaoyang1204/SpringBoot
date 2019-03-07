package com.xcy.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决Ajax跨域问题
 * @author xingchongyang
 *
 */
//@WebFilter(filterName="AjaxFilter",urlPatterns="/*")
public class AjaxFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;  
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");  //106.15.187.138:8090
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authentication"); 
        
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");
    	// 允许跨域请求中携带cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
        httpServletResponse.setHeader("Access-Control-Max-Age", "1800");//30min

        chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}