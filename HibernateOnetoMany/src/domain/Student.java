package domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="student")
public class Student {

	
	private String id;
	private String name;
	private int age;
	private Date birthday;
	
	
	@Id
	//@GeneratedValue Ĭ��auto����xml�е�native��ͬ��mysql-increment��oracle-sequence
/*	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")*/
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	//@Enumerated(EnumType.STRING)ö������
	@Column(name="age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//���ڱ�����������ֶ�
	@Transient
//	@Temporal(TemporalType.DATE)ֻ��������
//	@Temporal(TemporalType.TIME)ֻ��ʱ��
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
}
