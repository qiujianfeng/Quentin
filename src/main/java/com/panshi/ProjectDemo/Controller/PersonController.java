package com.panshi.ProjectDemo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panshi.ProjectDemo.Extend.PersonRespository;
import com.panshi.ProjectDemo.Model.PersonModel;
import com.panshi.ProjectDemo.Service.PersonException;
import com.panshi.ProjectDemo.Service.PersonService;

@RestController
public class PersonController {

	/*
	 * 一、项目属性配置优化
	 * 二、常用的URL注解使用
	 * 三、数据库操作和简单事务管理
	 * 四、表单验证
	 * 五、使用AOP处理请求
	 * 六、统一异常处理
	 */
	
	
	/**
	 * JPA(Java Persistence API)是Java持久化规范。它为Java开发人员提供了一种对象/关系映射工具来管理Java应用中的关系数据
	 * (1、添加jpa 依赖包
	 * (2、新建一个接口继承于JpaRepository
	 */
	
	@Autowired
	private PersonRespository personRespository;
	
	@Autowired
	private PersonService personService;
	/**
	 * 1、新增一条数据
	 */
	@GetMapping(value="/add")
	public PersonModel addPerson(@RequestParam("name") String name,@RequestParam("age") Integer age)
	{
		PersonModel personModel=new PersonModel();
		personModel.setAge(age);
		personModel.setName(name);
		return personRespository.save(personModel);
	}
	
	@GetMapping(value="/add3")
	public PersonModel addPerson(PersonModel personModel)
	{
		return personRespository.save(personModel);
	}
	
	
	/**
	 * 2、查询所有信息
	 */
	@GetMapping(value="/selectall")
	public List<PersonModel> selectPersons() {
		return personRespository.findAll();	
	}
	
	
	/**
	 * 3、查询一条数据
	 */
	@GetMapping(value="/selectone/{id}")
	public Optional<PersonModel> selectOne(@PathVariable("id") Integer id)
	{
		
		return personRespository.findById(id);
	}
	
	
	/**
	 * 4、更新一条数据
	 */
	@GetMapping(value="/update/{id}")
	public PersonModel updatePerson(@PathVariable("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Integer age)
	{
		PersonModel personModel=new PersonModel();
		personModel.setId(id);
		personModel.setAge(age);
		personModel.setName(name);
		return personRespository.save(personModel);
	}
	
	/**
	 * 5、删除一条数据
	 */
	@GetMapping(value="/del/{id}")
	public void delPerson(@PathVariable("id") Integer id)
	{
		personRespository.deleteById(id);
	}
	
	
	/**
	 * 7、同时插入两条数据（要求回滚）
	 */
	@GetMapping(value="/inserttwo")
	public void insertTwo() {
		 personService.insertTwo();
	}
	
	/**
	 * 7、同时插入两条数据（要求回滚）
	 */
	@GetMapping(value="/inserttwo2")
	public void insertTwo2() throws Exception{
		 personService.insertTwo2();
	}
	
	/**
	 * 8、通过年龄查询
	 */
	@GetMapping(value="/selectage/{age}")
	public List<PersonModel> selectByAge(@PathVariable("age") Integer age)
	{
		return personRespository.findByAge(age);
	}
	
	/**
	 * 9、优化插入 表单验证
	 */
	@GetMapping(value="/add2")
	public Object addPerson2(@Valid PersonModel personModel,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return bindingResult.getFieldError().getDefaultMessage();
		}
		personModel.setAge(personModel.getAge());
		personModel.setName(personModel.getName());
		return personRespository.save(personModel);
	}
	
	/**
	 * 10、使用AOP处理请求
	 * (1、首先添加aop 依赖包
	 * (2、新建一个拦截类HttpAspect，直接可以创建@Aspect ,并使用@Aspect和@Component标注这个类
	 */
	
	/**
	 * 11、统一异常处理   {“code”:1,”msg”:”年龄必填”}
	 */
	@GetMapping(value="/doif/{age}")
	public void doif(@PathVariable("age") Integer age) throws Exception
	{
		if(age<16)
		{
			//throw new Exception("你还是个小孩");
			throw new PersonException(100,"你还是个小孩");
		}
		else
		{
			throw new Exception("你已经长大了");
			//throw new PersonException(200,"你已经长大了");
		}
		
	}
	
	
}
