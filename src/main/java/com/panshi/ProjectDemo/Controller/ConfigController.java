package com.panshi.ProjectDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panshi.ProjectDemo.Model.ConfigModel;

@RestController
public class ConfigController {

	/*
	 * 一、项目属性配置优化
	 * 二、常用的URL注解使用
	 * 三、数据库操作和简单事务管理
	 * 四、表单验证
	 * 五、使用AOP处理请求
	 * 六、统一异常处理
	 */
	
	
	@Value(value="${content}")
	private String content;
	/**
	 * 1、获取配置数据
	 */
	@RequestMapping(value="/config1",method=RequestMethod.GET)  //@GetMapping(value="/config")
	public String getConfigValue() {
		return content;
	}
	
	/**
	 * 2、获取配置信息特定前缀格式的数据
	 */
	@Autowired
	private ConfigModel configModel;
	@GetMapping(value="/config2")
	public String getConfigInfo()
	{
		return configModel.getInfo();
	}
	
	/**
	 * 3、获取url中的数据   @PathVariable
	 */
	@GetMapping(value="/getarg1/{id}")
	public Integer getUrlArgs(@PathVariable("id") Integer ID)
	{
		return ID;
	}
	
	/**
	 * 4、获取url参数的值 @RequestParam
	 */
	@GetMapping(value="/getarg2")
	public Integer getUrlArgs1(@RequestParam("id") Integer ID)
	{
		return ID;
	}
}
