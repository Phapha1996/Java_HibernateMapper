package dao;

import org.hibernate.Session;

import utils.DbUtils;
import domain.LogTeacher;

public class LogTeacherDao{

	public void add(LogTeacher logt)throws Exception{
		Session session = DbUtils.getSessionFactory().getCurrentSession();
		session.save(logt);
		
	}
	
	
	
}
