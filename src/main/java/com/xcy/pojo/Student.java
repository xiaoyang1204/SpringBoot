package com.xcy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //声明一个实体，用的是Java规范下的注解
//@Table(name = "student") //映射的表名称
public class Student {

	@Id
	@GeneratedValue
	private Integer studentId;
	
	@Column(length = 20 , nullable = true)
	private String studentName;
	
	@Column(length = 50 , nullable = false)
	private String studentClass;
}
