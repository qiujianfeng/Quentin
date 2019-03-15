package com.panshi.ProjectDemo.Model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component                   				 //Spring启动时扫描该类，并添加到容器中
@ConfigurationProperties(prefix="person")    //使用前缀，属性不需要添加注解
public class ConfigModel {

	public String name;
	public Integer age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getInfo() {
		return name+":"+age;
	}
}
