package org.fage.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="_role")
public class Role {
	private int id;
	private String name;
	private List<Privilege> privileges = new LinkedList<Privilege>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="r_p",//修改中间表名称
			joinColumns={@JoinColumn(name="role_id")},//联合表的role外键字段，用一个集合的原因是怕有多个关联字段
			inverseJoinColumns={@JoinColumn(name="privilege_id")}//联合表的Privilege的外键字段
			)
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
	
}
