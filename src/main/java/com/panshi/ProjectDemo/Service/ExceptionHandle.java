package com.panshi.ProjectDemo.Service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panshi.ProjectDemo.Model.ResultModel;

@ControllerAdvice        //拦截异常并统一处理
public class ExceptionHandle {

	@ExceptionHandler(value=Exception.class)   //统一处理某一类异常，从而能够减少代码重复率和复杂度
	@ResponseBody                             //返回结果直接写入HTTP response body中
	public ResultModel handle(Exception e)
	{
		if(e instanceof PersonException)
		{
			PersonException personException =(PersonException) e;
			return ResultService.error(personException.getCode(), personException.getMessage());
		}
		
		return ResultService.error(-1, "未知错误");
	}
}
