package org.fage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_employee")
public class Employee {
	private int id;
	private String name;
	private Department department;
	

	@ManyToOne//多对一，部门为1，雇员为多
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return department;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键自动增长
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
