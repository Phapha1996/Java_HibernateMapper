package org.fage.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="_college")
public class College {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@OneToMany
	@JoinColumn(name="mycollege_id")
	public Set<Student> getStudents() {
		return students;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}


}
