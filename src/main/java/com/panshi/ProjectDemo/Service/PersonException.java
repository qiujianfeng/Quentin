package com.panshi.ProjectDemo.Service;

public class PersonException extends RuntimeException{
	private Integer code;

	public PersonException(Integer code,String msg) {
		super(msg);
		this.code=code;
	}
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
