package org.fage.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="_privilege")
public class Privilege {
	private int id;
	private String name;
	private String discription;
	private List<Role> roles = new LinkedList<Role>();
	
	public String getDiscription() {
		return discription;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@ManyToMany(mappedBy="privileges",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Role> getRoles() {
		return roles;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
