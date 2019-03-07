package com.xcy.util;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 
 * @author xingchongyang
 *
 */
public class UUIDUtil {
	
	public static String getUUID(){
		 return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void main(String[] args) {
		String salt = UUIDUtil.getUUID();
		System.out.println(salt);
		Md5Hash md5Password = new Md5Hash("123456",salt ,3);
		System.out.println(md5Password);
	}
}
