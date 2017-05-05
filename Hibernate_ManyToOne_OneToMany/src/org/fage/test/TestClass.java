package org.fage.test;

import java.text.Annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClass {

	@BeforeClass
	public static void before(){
		
	}
	
	
	@Test
	public void testCreate(){

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		sf.close();
	}
	
	@AfterClass
	public static void after(){
		
	}
	
	
	
}
