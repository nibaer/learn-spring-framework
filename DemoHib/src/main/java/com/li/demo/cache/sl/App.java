package com.li.demo.cache.sl;

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
       
       Session session1 = sf.openSession();
       Transaction tx = session1.beginTransaction();
       //saveAlien(session);
       fetchAlien(session1);
       tx.commit();
       session1.close();
       
       Session session2= sf.openSession();
       Transaction tx2 = session2.beginTransaction();
       fetchAlien(session2);
       tx2.commit();
       session2.close();
       
      
    }

	private static void fetchAlien(Session session) {
		Alien aAlien = (Alien) session.get(Alien.class, 101);
		System.out.println(aAlien);
		
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
