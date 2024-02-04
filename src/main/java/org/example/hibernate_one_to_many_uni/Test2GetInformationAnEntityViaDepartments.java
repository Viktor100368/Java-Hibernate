package org.example.hibernate_one_to_many_uni;

import org.example.hibernate_one_to_many_uni.entity.Department;
import org.example.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2GetInformationAnEntityViaDepartments {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session  = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep = session.get(Department.class,2);

            System.out.println(dep);
            System.out.println(dep.getEmps());
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            session.close();
            factory.close();
        }


    }
}
