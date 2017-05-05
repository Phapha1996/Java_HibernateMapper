package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


//@Embeddableʹ�ô�ע�������@Id������


//�������������ʵ�����л�������hashcode��equals����
public class EmployeePK implements Serializable{
	private static final Object EmployeePK = null;
	private int id;
	private String name;
	
	public EmployeePK(){
		super();
	}
	
	public EmployeePK(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EmployeePK){
			if(this.getId()==((EmployeePK) obj).getId()){
				return true;
			}
		}
		return false;
	}
	
	
}
