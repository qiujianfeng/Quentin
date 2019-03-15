package com.panshi.ProjectJpa.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_member")   
public class Member {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String position;
	
	@ManyToOne
	private Dept dept;
	
	@ManyToMany(mappedBy="members")
	private List<Project> projects = new ArrayList<>();
	
	
	public Member() {
		
	}

	public Member(String name,String position) {
		this.name=name;
		this.position=position;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
