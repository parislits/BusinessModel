package com.paris.BusinessModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Management extends OrganizationUnit{
	
	@Id
	@GeneratedValue
	private Long id;
	
	//One Management can have multiple departments
	@OneToMany(mappedBy="management")
	private List<Department> departments;

	@ManyToMany
	private List<Position> position = new ArrayList<>();

	public Management(String name , String description , ArrayList<Department> departments ,ArrayList<Position> position) {
		super(name , description);
		this.position=position;
		this.departments = departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<Position> getPosition() {
		return position;
	}


	public void setPosition(List<Position> position) {
		this.position = position;
	}
	
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

}
