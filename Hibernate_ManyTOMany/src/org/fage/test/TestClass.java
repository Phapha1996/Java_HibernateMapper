package org.fage.test;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.hibernate.Session;
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

		Role role = new Role();
		role.setName("产品经理");
		Privilege p = new Privilege();
		p.setName("商品管理");
		List list = new LinkedList();
		list.add(p);
		role.setPrivileges(list);
		list = new LinkedList();
		list.add(role);
		p.setRoles(list);
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		sf.close();
	}
	
	@Test
	public void testLoad(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Privilege p = session.load(Privilege.class, 1);
		System.out.println(p+"|||"+p.getRoles().size());
		session.getTransaction().commit();
		sf.close();
	}
	
	
	
	
	@AfterClass
	public static void after(){
		
	}
	
	
	
}
