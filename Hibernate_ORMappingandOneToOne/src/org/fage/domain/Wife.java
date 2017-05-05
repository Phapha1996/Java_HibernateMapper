package org.fage.domain;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table
public class Wife {
	private int id;
	private String name;
	private Date birthday;
	private Hansband hansband;
	
	//ע��һ�����ӹ�ϵ�����hansband������wife�Ǵ�
	//�����1��1˫�������Ӧ���ڶ���Ҳ����һ��OnetoOne��mappedBy=������
	@OneToOne//1��1�������
	@JoinColumn(name="hansband_id")//ʹ���������Ϊ������֣�wife����ο�Hansband�������
	//@PrimaryKeyJoinColumn//�ԶԷ���id������Ϊ�Լ�������
	public Hansband getHansband() {
		return hansband;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setHansband(Hansband hansband) {
		this.hansband = hansband;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
/*	
 * 
 * ��������
	@OneToOne
	@JoinColumns(
			@JoinColumn(name="wifeID",referencedColumnName="id")
			@JoinColumn(name="wifeName",referencedColumnName="name")
			)
	
	@IdClass(WifePk.class)
	@Id
	@Id
	
	
	*/
	
	/*@Embedded�����Ҳ����˵�������ݿ�ֻ����һ�ű����ڱ�����������󡣱���wife��hansband��һ����
		�÷����������жԷ������get����ͷ���������ע�⣬��xml����component��property����������
	*/
}
