package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5UpdateEntryInDB {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class,2);
//            emp.setSalary(4000);
            session.createQuery("update Employee set salary = 3000 where name = 'Marija'").executeUpdate();
            session.createQuery("update Employee set salary = 6000 where name = 'Semen'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            factory.close();
        }
    }
}
