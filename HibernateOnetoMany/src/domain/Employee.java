package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee")
@IdClass(value=EmployeePK.class)
public class Employee {
	private int id;
	private String name;
	//private EmployeePK pk;//��������
	private Date birthday;
	private String salary;
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column
	@Temporal(TemporalType.DATE)//ʱ����������
	public Date getBirthday() {
		return birthday;
	}
	
	//@Id
	//@EmbeddedIdʹ�ô�ע��ֻ��Ҫ��һ��ע��
/*	public EmployeePK getPk() {
		return pk;
	}
	public void setPk(EmployeePK pk) {
		this.pk = pk;
	}
*/	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
