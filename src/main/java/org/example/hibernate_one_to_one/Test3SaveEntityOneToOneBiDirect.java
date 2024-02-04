package org.example.hibernate_one_to_one;

import org.example.hibernate_one_to_one.entity.Detail;
import org.example.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3SaveEntityOneToOneBiDirect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session= factory.getCurrentSession();
            session.beginTransaction();
            Employee emp  = new Employee("Anton","Maslov","Mehanic",400);
            Detail detail = new Detail("Uljanjvsk","42305803","antoshka@gmail.com");
            emp.setEmpDetail(detail);
            detail.setEmployee(emp);

            session.save(detail);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }







//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory();
//        Session session = null;
//        try{
//            session = factory.getCurrentSession();
//
//            Employee emp = new Employee("Nikolaj","Nikolaev","it",2200);
//            Detail detail = new Detail("Samara","90875634","nikolaj@gmail.com");
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.save(emp);
//
//            session.getTransaction().commit();
//            System.out.println("done");
//        }finally {
//            session.close();
//            factory.close();
//        }
    }
}
