package com.paris.BusinessModel;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MyRepository {
	
	@Autowired
	EntityManager em;
	
	public void create() {
		/* We are going to create a Organination that it has 1 Management,
		 * that management has 2 Department and one of those department has one sub department.
		 * Also the management has 1 manager and all the departments have 1 chief and 8 employees 
		 */
		
		ArrayList<Department> departments = new ArrayList<>();
		ArrayList<Position> employeesofManagement = new ArrayList<>();
		ArrayList<Position> employeesofDepartment = new ArrayList<>();
		ArrayList<Department> subDepartments = new ArrayList<>();
		
		
		Position positionofManament = new Position("Διευθυντής" , "Υπεθυνός της Διευθυνσής", 1);
		Position positionofDepartment = new Position("προϊστάμενος" , "Υπεθυνός του τμήματος" ,1);
		Position positionofDepartment2 = new  Position("Υπαλληλός" , "Γραμματιακή υποστηριξή", 8);
		
		em.persist(positionofManament);
		em.persist(positionofDepartment);
		em.persist(positionofDepartment2);
		
		employeesofManagement.add(positionofManament);
		employeesofDepartment.add(positionofDepartment);
		employeesofDepartment.add(positionofDepartment2);
		
		Department subdepartment = new Department("Υποτμημά του Α" , "Υποστηριξή" 
				,null , employeesofDepartment);
		
		subDepartments.add(subdepartment);
		
		Department d1 = new Department("Τμημά Α" , "Υπευθυνο για αλλαγες" 
				,subDepartments , employeesofDepartment);
		
		Department d2 = new Department("Τμημά Β" , "Υπευθυνο τμημά για μισθοδοσία" 
				,null , employeesofDepartment);
		
		departments.add(d1);
		departments.add(d2);
		
		Management management = new Management("Διευθυνση Προσωπικού", 
				"Διευθυνση υπευθυνη για τις αναγκες του προσωπικο",
					null, employeesofManagement);
		
		em.persist(management);
		
		d1.setManagement(management);
		subdepartment.setParentDepartment(d1);
		d2.setManagement(management);

		em.persist(subdepartment);
		em.persist(d1);
		em.persist(d2);
	}

}
