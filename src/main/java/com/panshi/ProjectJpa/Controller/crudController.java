package com.panshi.ProjectJpa.Controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.event.spi.PreInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.panshi.ProjectJpa.Domain.Author;
import com.panshi.ProjectJpa.Domain.AuthorRespository;
import com.panshi.ProjectJpa.Domain.Dept;
import com.panshi.ProjectJpa.Domain.DeptRespository;
import com.panshi.ProjectJpa.Domain.Member;
import com.panshi.ProjectJpa.Domain.MemberRespository;
import com.panshi.ProjectJpa.Domain.Project;
import com.panshi.ProjectJpa.Domain.ProjectRespository;
import com.panshi.ProjectJpa.Domain.Salary;

@RestController
public class crudController {

	@Autowired
	public AuthorRespository authorRespository;

	@Autowired
	public DeptRespository deptRespository;
	
	@Autowired
	public MemberRespository memberRespository;
	
	@Autowired
	public ProjectRespository projectRespository;
	
	/**
	 * 2、按照自动以条件查询表数据 
	 * 格式：find + 限定词 + By + 实体属性名称 + 限定词或连接词 + 其他属性名称 + OrderBy + 排序属性 + 排序方向
	 */
	@GetMapping(value="find1")
	public Object findAuthorInfo()
	{
		List<Author> authors = authorRespository.findByNickAndPhoneOrderBySignDateDesc("jame", "18855556666");
		return JSON.toJSONString(authors,true);
	}
	
	/**
	 * 3、like条件查询
	 */
	@GetMapping(value="find2")
	public Object findAuthorByLike()
	{
		//return authorRespository.findByNickLike("b");
		List<Author> authors= authorRespository.findByNickLike("ja%");
		return JSON.toJSONString(authors,true);
	}
	
	/**
	 * 4、jpql语句查询
	 */
	@GetMapping(value="find3")
	public Object findArray()
	{
		List<Author> authors = authorRespository.findArray("jame", new Sort(Sort.Direction.DESC,"signDate"));
		return JSON.toJSONString(authors,true);
	}
	
	/**
	 * 5、sql语句查询
	 */
	@GetMapping(value="find4")
	public Object findBySql()
	{
		List<Author> authors =  authorRespository.findBySql("jame");
		return JSON.toJSONString(authors,true);
	}
	
	/**
	 * 6、更新表数据
	 */
	@GetMapping(value="update1")
	public Integer updateAuthor()
	{
		return authorRespository.updateAuthor("13688888887", 1);
	}
	
	/**
	 * 7、分页排序
	 */
	@GetMapping(value="page")
	public Object findAuthorPage()
	{
		Sort sort=new Sort(Sort.Direction.ASC,"id");
		Pageable pageable = new PageRequest(0,5,sort);
		
		Page<Author> pageauthor = authorRespository.getAuthorPage(pageable);
		return JSON.toJSONString(pageauthor,true);
	}
	
	/**
	 * 8、OneToOne属性
	 */
	@GetMapping(value="one")
	public void saveAuthorOne()
	{
		Author author=new Author();
		author.setAge(25);
		author.setNick("jame");
		author.setPhone("18855556666");
		author.setSignDate(new Date());
		author.setSalary(new Salary(new BigDecimal("2000"),"五险一金"));
		
		authorRespository.save(author);
	}

	/**
	 * 9、OneToMany属性
	 */
	@GetMapping(value="many")
	public void saveAuthorMany() {
		Dept dept=new Dept();
		dept.setDeptname("研发中心");
		dept.setDeptno("111");
		
		Member member1=new Member("小明","工程师");
		Member member2=new Member("小华","助理");
		
		dept.addMember(member1);
		dept.addMember(member2);
		
		deptRespository.save(dept);
	}
	
	/**
	 * 10、查询
	 */
	@GetMapping(value="selmany")
	public Object findAuthorMany() {
		Dept dept = deptRespository.findByDeptno("111");
		return JSON.toJSONString(dept, true);
		
	}
	
	
	/**
	 * 11、多表分页查询，不推荐，因为语句会很长，时间也慢。建议@OneToOne@OneToMany@ManyToOne@ManyToMany来标记实体表关系
	 * @return
	 */
	@GetMapping(value="page1")
	public Page<Object[]> findDeptPage()
	{
		return deptRespository.getDeptPageByLike("%小%", new PageRequest(0, 2));
	}
	
	/**
	 * 12、ManyToMany属性
	 */
	@GetMapping(value="manys")
	public void SetProjectInfo() {		
		
		Project project =new Project();
		project.setProjectName("php项目");
		projectRespository.save(project);

	}
	/**
	 * 13、ManyToMany属性,合并表数据
	 */
	@GetMapping(value="include")
	public Object includeMember() {		
		Member member= memberRespository.findByName("小明");
		Project project=projectRespository.findByProjectName("php项目");
	    project.getMembers().add(member);
	    return JSON.toJSONString(project, true);
	}
	/**
	 * 14、ManyToMany属性，排除表数据
	 */
	@GetMapping(value="unclude")
	public Object uncludeMember() {		

		Member member= memberRespository.findByName("小明");
		Project project=projectRespository.findByProjectName("php项目");
	    project.getMembers().remove(member);
	    return JSON.toJSONString(project, true);
	    
	}
	
	
}
