package org.example.hibernate_one_to_one;

import org.example.hibernate_one_to_one.entity.Detail;
import org.example.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2GetEntityOneToOneUniDirect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class,8);
            session.delete(employee);
           // System.out.println(employee.getEmpDetail());
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
