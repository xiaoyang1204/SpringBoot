package com.xcy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xcy.pojo.User;

@Repository
@Mapper
public interface UserMapper {
	
	int insertUser(@Param("user")User user);
	
	Integer findAllCount();

}
