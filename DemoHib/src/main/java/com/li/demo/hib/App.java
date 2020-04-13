package com.li.demo.hib;

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
       saveAlien(session);
       //fetchAlien(session);
       tx.commit();
       
      
    }

	private static void fetchAlien(Session session) {
		Alien aAlien = (Alien) session.get(Alien.class, 100);
		System.out.println(aAlien);
	}

	private static void saveAlien(Session session) {
		AlienName aName = new AlienName();
		aName.setFname("Li");
		aName.setLname("Zhang");
		aName.setMname("Linea");
		
		Alien aAlien = new Alien();
		aAlien.setAid(101);
		aAlien.setAname(aName);
		aAlien.setColor("rosa");
		session.save(aAlien);
	}
}
