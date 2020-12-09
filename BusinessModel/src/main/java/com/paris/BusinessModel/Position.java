package com.paris.BusinessModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Position {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String Name;
	
	private String description;
	
	//A position can belongs to many departments or managements
	//For example a supervisor can exists in many departments 
	
	@ManyToMany(mappedBy="position")
	List<Department> departments = new ArrayList<>();
	
	@ManyToMany(mappedBy="position")
	List<Management> managements = new ArrayList<>();

	//The number of the employees for a position
	private Integer Employees;
	
	public Position(String name, String description , Integer employees) {
		Name = name;
		this.description = description;
		this.Employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Management> getManagements() {
		return managements;
	}

	public void setManagements(List<Management> managements) {
		this.managements = managements;
	}

	public Integer getEmployees() {
		return Employees;
	}

	public void setEmployees(Integer employees) {
		Employees = employees;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
