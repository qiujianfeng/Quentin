package com.panshi.ProjectJpa.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_project") 
public class Project {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String projectName;
	
	@ManyToMany
    @JoinTable(
            name = "t_project_member",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members = new ArrayList<>();
	
	public Project()
	{
		
	}
	
	public Project(String projectname)
	{
		this.projectName=projectname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
}
