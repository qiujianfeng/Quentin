package com.panshi.ProjectJpa.Domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_salary")          //映射的表名
public class Salary {

	@Id
	@GeneratedValue
	private Integer id;
	
	private BigDecimal salary;
	
	private String welfare;

	@OneToOne(mappedBy = "salary")
	private Author author;
	
	public Salary() {
		
	}
	
	public Salary(BigDecimal salary,String welfare)
	{
		this.salary=salary;
		this.welfare=welfare;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getWelfare() {
		return welfare;
	}

	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
}
