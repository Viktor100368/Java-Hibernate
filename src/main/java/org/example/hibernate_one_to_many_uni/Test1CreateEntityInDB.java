package org.example.hibernate_one_to_many_uni;

import org.example.hibernate_one_to_many_uni.entity.Department;
import org.example.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1CreateEntityInDB {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            Department dep = new Department("HR",700,1700);
            Employee emp1 = new Employee("Maria" , "Smirova" , 1400);
            Employee emp2 = new Employee("Alex","Aculov",900);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();
            session.save(dep);
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
