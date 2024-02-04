package org.example.hibernate_one_to_many_bi;

import org.example.hibernate_one_to_many_bi.entity.Department;
import org.example.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1SaveDepartmentAndEmployeesToDB {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();

            Department dep = new Department("it",500,1200);
            Employee emp1 = new Employee("Alisa","Petrova",800);
            Employee emp2 = new Employee("Anna" , "Larina",1000);
            Employee emp3 = new Employee("Katja" , "Smirnova",1100);
            session.beginTransaction();

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            dep.addEmployeeToDepartment(emp3);

            session.save(dep);
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
