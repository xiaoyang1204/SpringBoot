package com.xcy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xcy.pojo.User;

@Controller
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 	存储字符串
	 */
	@RequestMapping("/reidsSet")
	public void set() {
		this.redisTemplate.opsForValue().set("key", "上海");
		System.out.println("存储成功~");
	}
	
	/**
	 *  取存储的字符串
	 * @return
	 */
	@RequestMapping("/reidsGet")
	@ResponseBody
	public String get() {
		String value = (String) this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
		return JSON.toJSONString(value);
	}
	
	/**
	 *  存储对象
	 * @return
	 */
	@RequestMapping("redisSetUser")
	@ResponseBody
	public String setUser() {
		User user = new User();
		user.setUsername("赵六");
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("user", user);
		System.out.println("存储成功~");
		return JSON.toJSONString("存储成功~");
	}
	
	/**
	 *  取存储的对象
	 * @return
	 */
	@RequestMapping("/reidsGetUser")
	@ResponseBody
	public void getUser() {
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		 Object object = this.redisTemplate.opsForValue().get("user");
		System.out.println(object);
		//return JSON.toJSONString(user);
	}
	
	/**
	 * 基于JSON对象格式存User对象
	 */
	@RequestMapping("/redisSetJsonUser")
	@ResponseBody
	public String SetUserJSON() {
		User user = new User();
		user.setUsername("李四");
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		this.redisTemplate.opsForValue().set("usersJson", user);
		return JSON.toJSONString("存储成功~");
	}
	
	/**
	 * 基于JSON格式取Users对象
	 */
	@RequestMapping("/redisGetJsonUser")
	@ResponseBody
	public String GetUserJSON(){
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		User users = (User)this.redisTemplate.opsForValue().get("usersJson");
		System.out.println(users);
		return JSON.toJSONString(users);
	}
}
