package org.example.hibernate_one_to_one;


import org.example.hibernate_one_to_one.entity.Detail;
import org.example.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1SaveEntityOneToOneUniDirect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
//            Employee employee= new Employee("Anna", "Petrova","it",2400);
//            Detail detail = new Detail("Piterburg","1234567","annaPetrova@gmail.com");

            Employee emp = new Employee("Petr","Petrov","sales",1500);
            Detail detail = new Detail("Moscow","908704356","petr@mail.ru");

            emp.setEmpDetail(detail);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("done");

        }finally {
            factory.close();
        }
    }
}
