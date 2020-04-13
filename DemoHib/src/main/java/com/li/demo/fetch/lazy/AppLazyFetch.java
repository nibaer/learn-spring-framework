package com.li.demo.fetch.lazy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppLazyFetch {
	  
	public static void main( String[] args ){    
       Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       SessionFactory sf = config.buildSessionFactory(reg);
       
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       saveMapping(session);
       
       Student s = (Student)session.get(Student.class, 49);
       System.out.println(s);
       System.out.println(s.getName());
       List<Laptop> laptops= s.getLaptop();
       for(Laptop l: laptops) {
    	   System.out.println(l);
       }
       tx.commit(); 
       
    }

	//prepare the data
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
		
		session.save(laptop1);
		session.save(laptop2);
		session.save(s);
		
	}

}
