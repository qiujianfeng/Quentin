package com.panshi.ProjectDemo.Service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.log.Log;

@Aspect      //作用是把当前类标识为一个切面供容器读取
@Component
public class httpAspect {

	@Pointcut("execution(public * com.panshi.ProjectDemo.Controller.PersonController.*(..))")
	public void Log()
	{}
	
	@Before("Log()")
	public void doBefore()
	{
		System.out.println("之前输出");
	}
	
	@After("Log()")
	public void doAfter()
	{
		System.out.println("后面输出");
	}
}
