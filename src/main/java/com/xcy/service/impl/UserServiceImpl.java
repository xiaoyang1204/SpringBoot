package com.xcy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcy.mapper.UserMapper;
import com.xcy.pojo.User;
import com.xcy.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public Integer findAllCount() {
		return userMapper.findAllCount();
	}
}
