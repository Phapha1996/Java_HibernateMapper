package org.fage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="_department")
public class Department {
	
	private int id;
	private String name;
	private Date setupTime;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	@Column(name="setupTime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSetupTime() {
		return setupTime;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void setSetupTime(Date setupTime) {
		this.setupTime = setupTime;
	}

	
}
