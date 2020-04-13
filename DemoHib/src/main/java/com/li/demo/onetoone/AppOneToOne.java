package com.li.demo.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppOneToOne {
	  
	public static void main( String[] args ){    
       Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       SessionFactory sf = config.buildSessionFactory(reg);
       
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       saveMapping(session);
       tx.commit(); 
    }

	private static void saveMapping(Session session) {
		Laptop laptop = new Laptop();
		laptop.setLid(100);
		laptop.setLname("macbook");
		
		Student s = new Student();
		s.setName("Li");
		s.setMarks(100);
		s.setRollno(49);
		s.setLaptop(laptop);
		
		session.save(laptop);
		session.save(s);
		
	}

}
