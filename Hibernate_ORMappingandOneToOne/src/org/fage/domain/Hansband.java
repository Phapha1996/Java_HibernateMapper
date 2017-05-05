package org.fage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table
public class Hansband {
	private int id;
	private String name;
	//private Wife wife;如果需要设置双向关联
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*@OneToOne(mappedBy="hansband")双向关联的话，mappedBy必设，
	 * 意思是：Hibernate你不用给我在Hansband表生成外键，只参考wife对象的hansband生成就行！
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	*/
	
	
}
