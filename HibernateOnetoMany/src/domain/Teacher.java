package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="teacher")
public class Teacher {
	private int id;
	private String name;
	private String title;

	//ָ��������������Ϊuuid
	//@GeneratedValue(generator="uuid")
	//@GeneratedValue(generator="uuid",strategy=GenerationType.AUTO)������������һ���Ǹ�������ָ������������ѡ�����ڶ�����ָ�����ɲ���
	//Hibernate�ṩ������������������ҵ�������Ϊuuid��������
	//@GenericGenerator(name = "uuid", strategy = "uuid")
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public	int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
