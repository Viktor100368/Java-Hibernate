package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3CreatAndGetEntryInDB {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Nikolaj","Nikolaev","Salles",2950);
            session.beginTransaction();
            session.save(emp);
            int myId = emp.getId();
            Employee employee = session.get(Employee.class,myId);
            System.out.println(employee);
            System.out.println("done");
            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
