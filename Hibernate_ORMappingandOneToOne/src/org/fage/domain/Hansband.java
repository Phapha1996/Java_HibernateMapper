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
	//private Wife wife;�����Ҫ����˫�����
	
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
	
	/*@OneToOne(mappedBy="hansband")˫������Ļ���mappedBy���裬
	 * ��˼�ǣ�Hibernate�㲻�ø�����Hansband�����������ֻ�ο�wife�����hansband���ɾ��У�
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	*/
	
	
}
