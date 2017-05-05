package test;

import java.text.Annotation;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.DbUtils;
import dao.LogTeacherDao;
import dao.TeacherDao;
import domain.Employee;
import domain.EmployeePK;
import domain.LogTeacher;
import domain.Student;
import domain.Teacher;


//对象在persisten状态的时候改变其中一个字段，总会导致在commit的时候改变数据库中的相应记录

public class TestClass {
	
	private static SessionFactory factory;
	
	@BeforeClass
	public static void beforetest(){
		/*
		 * 1.类Configuration的configure方法是读取Hibernate.cfg.xml文件，或者读取annotation，
		 * 如果你的Hibernate配置文件被修改了，使用configure（String fileName）来指定，如configure（"Hibernate.xml"）
		 * 
		 * 2.sessionfactory类似一个管理数据库连接池的API，请注意，其实并没那么简单！！
		 * 
		 */
		
		factory = new Configuration().configure().buildSessionFactory();
	}
	
/*	
	@Test
	public void testStudent(){
		Student s = new Student();
		s.setName("fage");
		s.setAge(21);
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	**/
	
	
	@Test
	public void testTeacher(){
		Teacher t = new Teacher();
		//transeit状态
		t.setName("t1");
		t.setTitle("高级教师");
		System.out.println(t.getId());
		Session session = factory.openSession();
		session.beginTransaction();
		//persisten状态
		session.save(t);
		//t.setName("法法");
		System.out.println(t.getId());
		session.getTransaction().commit();
		//最后一种状态
		System.out.println(t.getId());
	}
	
	
	@Test
	public void testEmployee(){
		/*
		 * 此方法只测试联合主键
		 * 1.@embeddable（在联合主键类的类头）与@id(在实体类)联合使用
		 *2.@embeddableId（在实体类中联合主键的get方法上）可以单独使用（常用）
		 *3.@Idclass（XXX.class）(在实体类的类头用)与@Id(单独属性)、@Id(单独属性)连用
		 *
		 */
		
		Employee e = new Employee();
		//e.setPk(new EmployeePK(1,"fage"));
		e.setId(1);
		e.setName("fafaf");
		e.setBirthday(new Date());
		e.setSalary("5000");
		
		Session session = factory.getCurrentSession();
//		factory.getCurrentSession();
		/*
		 * openSession（）与getCurrentSession（）的区别：
		 * 1.前者永远都是新建session，后者在当前线程里找有没有session，没有的话就建新的
		 * 2.前者需要close，后者在commit中自动帮close
		 * 3.后者用途更好，在处理事务的时候非常的有用。
		 * 
		 */
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		
		
	}
	
	
	@Test
	public void testGet(){
		
		Teacher t = new Teacher();
		t.setId(1);
		//隐藏状态
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		t= session.get(Teacher.class, t.getId());
		//get方法执行之后变成persistten状态
		System.out.println(t.getId()+t.getName()+t.getTitle());
		//如果在这里面set了，也会导致数据库里面的数据发生变化
		t.setName("doudou");
		session.getTransaction().commit();
		System.out.println(t.getId()+t.getName()+t.getTitle());
		//最后的一种状态
	}
	
	
	//注意load方法与get方法的不同！
	@Test
	public void testLoad_Update(){
		Teacher t = new Teacher();
		t.setId(1);
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		t = session.load(Teacher.class, t.getId());
		//	System.out.println(t.getId()+t.getName()+t.getTitle());
		//只有在事务里面调用了，Hibernate才给你发sql语句
		//当前还没有被提交，所以还驻留在缓存中，在提交的时候，再一次跟数据库校验
		t.setName("fage");
		session.getTransaction().commit();
//		System.out.println(t.getId()+t.getName()+t.getTitle());
	}
	
	
	
	@Test
	public void testUpdate_HQL(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		//常用,使用HQL语句进行更新
		Query q = session.createQuery("update Teacher t set t.name='fafafa' where t.id=1");
		q.executeUpdate();
		session.getTransaction().commit();
		
	}
	
	
	
	@Test
	public void testDelete(){
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		session.delete(session.load(Teacher.class, 1));
		session.getTransaction().commit();
		
		
	}
	
	
	
	@Test
	public void testUpdate(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Teacher t = session.get(Teacher.class, 1);
		t.setName("dada");
		//这个update全部重设，如果我只想改单条语句。。
		session.update(t);
		session.getTransaction().commit();
		
		
	}
	
	@Test
	public void testTeacher_Log_Dao_TransAction(){
		//尝试将两张表在一个事务内做完，log为日志表，另一个为teacher实体表
		//getCurrentSession可以确定事务的边界
		//openSession无论任何时候都只能新创建Session
		TeacherDao tdao = new TeacherDao();
		LogTeacherDao logtdao = new LogTeacherDao();
		Teacher t = new Teacher();
		t.setName("蔡智法");
		t.setTitle("高级教师");
		LogTeacher log = new LogTeacher();
		log.setName(t.getName()+"注册");
		log.setTime(new Date());
		try{
			Session session = DbUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			tdao.add(t);
			logtdao.add(log);
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("失败");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@AfterClass
	public static void testafter(){
		factory.close();
		
	}
	
	
}
