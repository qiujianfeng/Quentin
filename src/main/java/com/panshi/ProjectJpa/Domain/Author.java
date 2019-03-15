package com.panshi.ProjectJpa.Domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="t_author")          //映射的表名
public class Author {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="nick_name")      //映射到表字段的列名
	private String nick;
	
	@Transient
	private Integer age;
	
	private String phone;
	
	@Temporal(TemporalType.DATE)
	private Date signDate;

	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="o_id")    //,referencedColumnName="id"
	private Salary salary;
	
	
	public Author() {
		//构造函数   
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}


	
	
}
