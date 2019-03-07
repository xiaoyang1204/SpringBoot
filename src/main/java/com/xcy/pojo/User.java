package com.xcy.pojo;

import java.io.Serializable;

import javax.persistence.Table;

@Table(name = "user")
public class User implements Serializable{

	/**
	 * 序列化标识符
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String username;
	
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(Integer id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public User() {
		super();
	}
	
	
}
