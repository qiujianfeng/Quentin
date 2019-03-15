package com.panshi.ProjectJpa.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_dept")          //映射的表名
public class Dept {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String deptno;
	
	private String deptname;
	
	@OneToMany(mappedBy = "dept", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<Member> members=new ArrayList<>();
	
	public Dept() {
		
	}
	
	public void addMember(Member member) {
		member.setDept(this);
		members.add(member);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
}
