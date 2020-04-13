package com.li.demo.hql;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	  
	public static void main( String[] args ){    
       Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       SessionFactory sf = config.buildSessionFactory(reg);
       
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       //saveStudents(session);
       //queryStudent1(session);
       //queryStudent2(session);
       //queryStudent3(session);
       //queryStudent4(session);
       //queryStudent5(session);
       //queryStudent6(session);
       //queryStudent7(session);
       queryStudent8(session);
       tx.commit(); 
       session.close();
       
    }

	private static void queryStudent1(Session session) {
		Query q = session.createQuery("from Student where marks > 80");
		   List<Student> students = q.list();
		   for(Student s: students) {
			   System.out.println(s);
		   }
	}
	
	private static void queryStudent2(Session session) {
		Query q = session.createQuery("from Student where rollno=49");
		Student s = (Student)q.uniqueResult();
		System.out.println(s);
	}
	
	private static void queryStudent3(Session session) {
		Query q = session.createQuery("select rollno, name, marks from Student where rollno=49");
		Object[] s = (Object[])q.uniqueResult();
		for (Object o : s) {
			System.out.println(o);
		}
	}
	
	private static void queryStudent4(Session session) {
		Query q = session.createQuery("select rollno, name, marks from Student");
		List<Object[]> students = (List<Object[]>)q.list();
		for (Object[] s : students) {
			System.out.println(s[0] + " : "+s[1] + " : " + s[2]);
		}
	}
	
	private static void queryStudent5(Session session) {
		Query q = session.createQuery("select avg(marks) from Student");
		Double s = (Double)q.uniqueResult();
		System.out.println(s);
	}
	
	private static void queryStudent6(Session session) {
		int b = 80;
		Query q = session.createQuery("select avg(marks) from Student where marks>= :b");
		q.setParameter("b", b);
		Double s = (Double)q.uniqueResult();
		System.out.println(s);
	}
	
	private static void queryStudent7(Session session) {
		SQLQuery q = session.createSQLQuery("select * from Student where marks > 80");
		q.addEntity(Student.class);
		List<Student> students = q.list();
		for(Student s: students) {
			   System.out.println(s);
		   }
	}
	
	private static void queryStudent8(Session session) {
		SQLQuery q = session.createSQLQuery("select name, marks from Student where marks > 80");
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List students = q.list();
		for(Object o: students) {
			Map m = (Map)o;
			System.out.println(m.get("name")+" : " + m.get("marks"));
		}
	}


	private static void saveStudents(Session session) {
		Random r=new Random();
		   for(int i=1;i<51;i++) {
			   Student s=new Student();
			   s.setRollno(i);
			   s.setName("Name "+i);
			   s.setMarks(r.nextInt(100));
			   session.save(s);
		   }
	}

	
}
