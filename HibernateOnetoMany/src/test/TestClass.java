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


//������persisten״̬��ʱ��ı�����һ���ֶΣ��ܻᵼ����commit��ʱ��ı����ݿ��е���Ӧ��¼

public class TestClass {
	
	private static SessionFactory factory;
	
	@BeforeClass
	public static void beforetest(){
		/*
		 * 1.��Configuration��configure�����Ƕ�ȡHibernate.cfg.xml�ļ������߶�ȡannotation��
		 * ������Hibernate�����ļ����޸��ˣ�ʹ��configure��String fileName����ָ������configure��"Hibernate.xml"��
		 * 
		 * 2.sessionfactory����һ���������ݿ����ӳص�API����ע�⣬��ʵ��û��ô�򵥣���
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
		//transeit״̬
		t.setName("t1");
		t.setTitle("�߼���ʦ");
		System.out.println(t.getId());
		Session session = factory.openSession();
		session.beginTransaction();
		//persisten״̬
		session.save(t);
		//t.setName("����");
		System.out.println(t.getId());
		session.getTransaction().commit();
		//���һ��״̬
		System.out.println(t.getId());
	}
	
	
	@Test
	public void testEmployee(){
		/*
		 * �˷���ֻ������������
		 * 1.@embeddable�����������������ͷ����@id(��ʵ����)����ʹ��
		 *2.@embeddableId����ʵ����������������get�����ϣ����Ե���ʹ�ã����ã�
		 *3.@Idclass��XXX.class��(��ʵ�������ͷ��)��@Id(��������)��@Id(��������)����
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
		 * openSession������getCurrentSession����������
		 * 1.ǰ����Զ�����½�session�������ڵ�ǰ�߳�������û��session��û�еĻ��ͽ��µ�
		 * 2.ǰ����Ҫclose��������commit���Զ���close
		 * 3.������;���ã��ڴ��������ʱ��ǳ������á�
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
		//����״̬
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		t= session.get(Teacher.class, t.getId());
		//get����ִ��֮����persistten״̬
		System.out.println(t.getId()+t.getName()+t.getTitle());
		//�����������set�ˣ�Ҳ�ᵼ�����ݿ���������ݷ����仯
		t.setName("doudou");
		session.getTransaction().commit();
		System.out.println(t.getId()+t.getName()+t.getTitle());
		//����һ��״̬
	}
	
	
	//ע��load������get�����Ĳ�ͬ��
	@Test
	public void testLoad_Update(){
		Teacher t = new Teacher();
		t.setId(1);
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		t = session.load(Teacher.class, t.getId());
		//	System.out.println(t.getId()+t.getName()+t.getTitle());
		//ֻ����������������ˣ�Hibernate�Ÿ��㷢sql���
		//��ǰ��û�б��ύ�����Ի�פ���ڻ����У����ύ��ʱ����һ�θ����ݿ�У��
		t.setName("fage");
		session.getTransaction().commit();
//		System.out.println(t.getId()+t.getName()+t.getTitle());
	}
	
	
	
	@Test
	public void testUpdate_HQL(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		//����,ʹ��HQL�����и���
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
		//���updateȫ�����裬�����ֻ��ĵ�����䡣��
		session.update(t);
		session.getTransaction().commit();
		
		
	}
	
	@Test
	public void testTeacher_Log_Dao_TransAction(){
		//���Խ����ű���һ�����������꣬logΪ��־����һ��Ϊteacherʵ���
		//getCurrentSession����ȷ������ı߽�
		//openSession�����κ�ʱ��ֻ���´���Session
		TeacherDao tdao = new TeacherDao();
		LogTeacherDao logtdao = new LogTeacherDao();
		Teacher t = new Teacher();
		t.setName("���Ƿ�");
		t.setTitle("�߼���ʦ");
		LogTeacher log = new LogTeacher();
		log.setName(t.getName()+"ע��");
		log.setTime(new Date());
		try{
			Session session = DbUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			tdao.add(t);
			logtdao.add(log);
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("ʧ��");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@AfterClass
	public static void testafter(){
		factory.close();
		
	}
	
	
}
