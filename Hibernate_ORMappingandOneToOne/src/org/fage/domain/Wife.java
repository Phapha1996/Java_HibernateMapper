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
	
	//注意一下主从关系，这边hansband是主，wife是从
	//如果是1对1双向关联，应该在对面也设置一个OnetoOne（mappedBy=“”）
	@OneToOne//1对1外键关联
	@JoinColumn(name="hansband_id")//使本表外键列为这个名字，wife外键参考Hansband表的主键
	//@PrimaryKeyJoinColumn//以对方的id参照作为自己的主键
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
 * 联合主键
	@OneToOne
	@JoinColumns(
			@JoinColumn(name="wifeID",referencedColumnName="id")
			@JoinColumn(name="wifeName",referencedColumnName="name")
			)
	
	@IdClass(WifePk.class)
	@Id
	@Id
	
	
	*/
	
	/*@Embedded组件，也就是说，在数据库只生成一张表，而在编程中两个对象。比如wife是hansband的一部分
		用法：在声明有对方对象的get方法头顶加入这个注解，在xml中用component与property来进行配置
	*/
}
