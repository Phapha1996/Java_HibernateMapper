package org.fage.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="_user")
public class User {
	private int id;
	private String name;
	private Date birthday;
	private UserGroup usergroup;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBirthday() {
		return birthday;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	@ManyToOne
	@JoinColumn(name="usergroupID")
	public UserGroup getUsergroup() {
		return usergroup;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsergroup(UserGroup usergroup) {
		this.usergroup = usergroup;
	}
	
	
	
}
