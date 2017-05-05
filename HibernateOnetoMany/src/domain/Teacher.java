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

	//指定生成器的名称为uuid
	//@GeneratedValue(generator="uuid")
	//@GeneratedValue(generator="uuid",strategy=GenerationType.AUTO)两个参数，第一个是根据名字指定生成器（可选），第二个是指定生成策略
	//Hibernate提供的生成器，上述语句找到了名字为uuid的生成器
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
