package com.li.demo.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppManyToMany {
	  
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
		Laptop laptop1 = new Laptop();
		laptop1.setLid(100);
		laptop1.setLname("macbook");
		Laptop laptop2 = new Laptop();
		laptop2.setLid(101);
		laptop2.setLname("Lenovo");
		
		Student s = new Student();
		s.setName("Li");
		s.setMarks(100);
		s.setRollno(49);
		s.getLaptop().add(laptop1);
		s.getLaptop().add(laptop2);
		
		laptop1.getStudent().add(s);
		laptop2.getStudent().add(s);
		
		session.save(laptop1);
		session.save(laptop2);
		session.save(s);
		
	}

}
