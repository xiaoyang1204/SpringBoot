package com.xcy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xcy.common.JSONResult;
import com.xcy.pojo.User;
import com.xcy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/insertUser" , method = RequestMethod.POST)
	@ResponseBody
	public String insertUser(User user) {
		Integer count = userService.findAllCount();
		if(count < 11) {
			int i = userService.insertUser(user);
			if(i > 0) {
				return JSON.toJSONString(JSONResult.ok("注册成功~"));
			}
				return JSON.toJSONString(JSONResult.errorMsg("注册失败，请重试~"));
		}
		return JSON.toJSONString(JSONResult.errorMsg("注册人额已满~"));
	}
	
}
