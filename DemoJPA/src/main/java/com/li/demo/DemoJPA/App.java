package com.li.demo.DemoJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("pi");
        EntityManager m = f.createEntityManager();
        // find an entity from the database
        Laptop laptop = m.find(Laptop.class, 100);
        System.out.println(laptop);
        
        // store a newly created entity in the database
        Laptop a = new Laptop();
        a.setBrand("lenovo");
        a.setLid(99);
        a.setPrice(889);
        //persist the entity
        m.getTransaction().begin();
        m.persist(a);
        m.getTransaction().commit();
        

    }
}
