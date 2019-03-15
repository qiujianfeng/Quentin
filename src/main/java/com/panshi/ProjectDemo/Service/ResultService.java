package com.panshi.ProjectDemo.Service;

import com.panshi.ProjectDemo.Model.PersonModel;
import com.panshi.ProjectDemo.Model.ResultModel;

public class ResultService {

	//成功
	public static ResultModel success(PersonModel person) {
		ResultModel result=new ResultModel();
		result.setCode(1);
		result.setMsg("成功");
		return result;
	}
	
	
	//出错
	public static ResultModel error(Integer code,String msg) {
		ResultModel result=new ResultModel();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
