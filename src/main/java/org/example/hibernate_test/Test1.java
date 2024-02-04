package org.example.hibernate_test;
import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
    try(SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory()){
        Session session = factory.getCurrentSession();
        Employee emp = new Employee("Semen","Victorov","driver",2000);
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        System.out.println("done");
    }









//       try(SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .buildSessionFactory()) {
//
//           Session session = factory.getCurrentSession();
//           Employee employee = new Employee(4, "Irina",
//                   "Semenova", "Cockier", 1200);
//           session.beginTransaction();
//           session.save(employee);
//           session.getTransaction().commit();
//       }

    }
}
