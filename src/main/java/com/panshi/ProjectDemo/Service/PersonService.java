package com.panshi.ProjectDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panshi.ProjectDemo.Extend.PersonRespository;
import com.panshi.ProjectDemo.Model.PersonModel;

@Service
public class PersonService {

	@Autowired
	private PersonRespository personRespository;
	
	@Transactional
	public void insertTwo() {
		PersonModel personModel=new PersonModel();
		personModel.setAge(20);
		personModel.setName("zzz");
	    personModel =personRespository.save(personModel);
		
		PersonModel personModel2=new PersonModel();
		personModel2.setAge(21);
		personModel2.setName("ccc");
		personModel2 = personRespository.save(personModel2);
		
		
	}
	
	@Transactional
	public void insertTwo2()  throws Exception{
		PersonModel personModel=new PersonModel();
		personModel.setAge(12);
		personModel.setName("bbb");
	    personModel =personRespository.save(personModel);
		
		PersonModel personModel2=new PersonModel();
		personModel2.setAge(222);
		personModel2.setName("xxxccccccc");
		personModel2 = personRespository.save(personModel2);
		
		
	}
}
