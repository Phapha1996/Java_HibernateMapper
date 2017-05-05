package dao;

import org.hibernate.Session;

import utils.DbUtils;
import domain.Teacher;

public class TeacherDao {

	
	public void add(Teacher t)throws Exception{
		Session session = DbUtils.getSessionFactory().getCurrentSession();
		session.save(t);
	}
	
	
	
}
