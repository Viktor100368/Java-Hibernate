package org.example.hibernate_one_to_many_bi;

import org.example.hibernate_one_to_many_bi.entity.Department;
import org.example.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test2GetListEmployeesViaDepartment {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            //получаем департамент и всех работников связанных с ним
//            Department department = session.get(Department.class,1);
//
//            System.out.println(department);
//            System.out.println(department.getEmps());
// или получить работника и связанный с ним департамент
            Employee employee = session.get(Employee.class,1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();
            System.out.println("done");
        }finally {

            session.close();
            factory.close();
        }
    }
}
