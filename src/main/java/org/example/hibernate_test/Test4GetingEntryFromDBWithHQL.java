package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4GetingEntryFromDBWithHQL {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //получение данных из БД с помощью HQL
            List<Employee> emps = session.createQuery("from Employee "
                    +"where name = 'Semen' and salary > 2000").getResultList();
            for(Employee e : emps){
                System.out.println(e);
            }
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            factory.close();
        }

    }
}
