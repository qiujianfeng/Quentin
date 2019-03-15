package com.panshi.ProjectDemo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="person_model")         //定义映射数据库表的名称
public class PersonModel {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Min(value=10,message="年龄太小")
	private Integer age;
	
	public PersonModel() {
		// TODO 自动生成的构造函数存根
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
}
