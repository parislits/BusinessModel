package com.paris.BusinessModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department extends OrganizationUnit{
	
	@Id
	@GeneratedValue
	private Long id;
	
	//When a sub-department is created it has to set a parent department
	@ManyToOne(fetch=FetchType.LAZY)
	private Department parentDepartment;

	//A department can have many sub-departments
	@OneToMany(mappedBy="parentDepartment")
	private List<Department> departments ;
	
	//When we are creating a department we have to set a management that it belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	private Management management;

	//A department has positions
	@ManyToMany
	private List<Position> position = new ArrayList<>();
	
	public Department(String name , String description , ArrayList<Department> departments ,ArrayList<Position> position) {
		super(name , description );
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


	public Department getParentDepartment() {
		return parentDepartment;
	}


	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}


	public Management getManagement() {
		return management;
	}


	public void setManagement(Management management) {
		this.management = management;
	}
	
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}
	
	
	public List<Position> getPosition() {
		return position;
	}


	public void setPosition(List<Position> position) {
		this.position = position;
	}
	

}
