package com.li.demo.getload;

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
       session.beginTransaction();
       //getLaptop(session);
       loadLaptop(session);
       session.getTransaction().commit();
       session.close();
    }

	
	private static void loadLaptop(Session session) {
		Laptop laptop =(Laptop) session.load(Laptop.class, 100);
		//System.out.println(laptop);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(laptop);
	}


	private static void getLaptop(Session session) {
		Laptop laptop =(Laptop) session.get(Laptop.class, 100);
		//System.out.println(laptop);		
	}


	private static void persistentState(Session session) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(100);
		laptop.setBrand("macbook");
		laptop.setPrice(1500);
		session.save(laptop);
		laptop.setPrice(1005);
		
	}

}
