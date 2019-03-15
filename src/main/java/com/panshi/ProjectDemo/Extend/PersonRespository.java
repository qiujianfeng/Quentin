package com.panshi.ProjectDemo.Extend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panshi.ProjectDemo.Model.PersonModel;

public interface PersonRespository extends JpaRepository<PersonModel, Integer>{

	//通过年龄查询
	public List<PersonModel> findByAge(Integer age);
	
	
		
}
