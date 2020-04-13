package com.li.demo.cache.fl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
             
       Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       SessionFactory sf = config.buildSessionFactory(reg);
       
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       //saveAlien(session);
       fetchAlien(session);
       tx.commit();
       
      
    }

	private static void fetchAlien(Session session) {
		Alien aAlien = (Alien) session.get(Alien.class, 101);
		System.out.println(aAlien);
		Alien aAlien2 = (Alien) session.get(Alien.class, 101);
		System.out.println(aAlien2);
	}

	private static void saveAlien(Session session) {
		
		
		Alien aAlien = new Alien();
		aAlien.setAid(101);
		aAlien.setAname("conny");
		aAlien.setColor("rosa");
		session.save(aAlien);
		
		aAlien = new Alien();
		aAlien.setAid(102);
		aAlien.setAname("Li");
		aAlien.setColor("yellow");
		session.save(aAlien);
	}
}
