package com.li.demo.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	  
	public static void main( String[] args ){    
       Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       SessionFactory sf = config.buildSessionFactory(reg);
       
       Session session = sf.openSession();
       //persistentState(session);
       detachEntity(session);
       //deleteEntity(session);
       session.close();
    }

	private static void detachEntity(Session session) {
		session.beginTransaction();
		Laptop laptop = new Laptop();
		laptop.setLid(100);
		laptop.setBrand("macbook");
		laptop.setPrice(1500);
		session.save(laptop);
		//session.clear();
		laptop.setPrice(1005);
		//session.detach(laptop);		
		session.getTransaction().commit();		
		
	}
	
	private static void deleteEntity(Session session) {
		session.beginTransaction();
		Laptop laptop = new Laptop();
		laptop.setLid(100);
		laptop.setBrand("macbook");
		laptop.setPrice(1500);
		session.save(laptop);
		session.delete(laptop);
		laptop.setPrice(1005);
		session.getTransaction().commit();		
		
	}

	private static void persistentState(Session session) {
		session.beginTransaction();
		Laptop laptop = new Laptop();
		laptop.setLid(100);
		laptop.setBrand("macbook");
		laptop.setPrice(1500);
		session.save(laptop);
		laptop.setPrice(1005);
		session.getTransaction().commit();
	}

}
