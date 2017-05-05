package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbUtils {
	private static SessionFactory factory;
	
	
	static{
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	
	public static void closeFactory(){
		factory.close();
	}
	
}
