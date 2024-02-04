package org.example.hibernate_one_to_many_bi.ljad_and_fetch_type;

import org.example.hibernate_one_to_many_bi.entity.Department;
import org.example.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
//для использования fechType  в аннотации @OneToMany класса Department нужно указать атрибут fetch =
// FetchType.EAGER или LAZY ОТ этого зависит как будут выбираться данные каскадом или отдельно



            session.beginTransaction();
            System.out.println("get department");
            Department dep = session.get(Department.class,2);
            System.out.println("show department");
            System.out.println(dep);
            dep.getEmps().get(0);
            session.getTransaction().commit();
            System.out.println("show employee");
            System.out.println(dep.getEmps());
//===========================================================
//            session.beginTransaction();
//            System.out.println("get department");
//            Department dep = session.get(Department.class,2);
//            System.out.println("show department");
//            System.out.println(dep);
//            System.out.println("show employee");
//            System.out.println(dep.getEmps());
//            session.getTransaction().commit();
//==================================================================
//            Department department = new Department("Sales",800,1500);
//            Employee emp1 = new Employee("Maina" ,"Marinina",1000);
//            Employee emp2 = new Employee("Ivan","Ivanov",800);
//            Employee emp3 = new Employee("Elena","Elenina",1500);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//
//           session.beginTransaction();
//            session.save(department);

//            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            session.close();
            factory.close();
        }
    }
}
