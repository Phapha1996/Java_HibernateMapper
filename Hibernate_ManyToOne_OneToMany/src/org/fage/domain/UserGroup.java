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
@Table(name="_usergroup")
public class UserGroup {
	private int id;
	private String name;
	private Set<User> set = new HashSet<User>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@OneToMany(mappedBy="usergroup")
	public Set<User> getSet() {
		return set;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSet(Set<User> set) {
		this.set = set;
	}
	
	
}
