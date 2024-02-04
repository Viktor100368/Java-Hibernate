package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Marija","Marinina","HR",3500);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            int myId = emp.getId();
            session= factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class,myId);
            System.out.println(employee);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
