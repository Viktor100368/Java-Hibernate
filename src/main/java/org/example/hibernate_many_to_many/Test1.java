package org.example.hibernate_many_to_many;

import org.example.hibernate_many_to_many.entity.Child;
import org.example.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();

//            Child child1 = new Child("Vadic",11);
//            Child child2 = new Child("Masha",12);
//            Child child3 = new Child("Vanja",9);
//            Section section1 = new Section("football");
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child3);
//            section1.addChildToSection(child2);
//
//            session.beginTransaction();
//            session.save(section1);
//
//            session.getTransaction().commit();
//            System.out.println("done");
            //=====================================
//            Section section1 = new Section("Chess");
//            Section section2 = new Section("Math");
//            Section section3 = new Section("Physics");
//            Child child = new Child("Andrew",12);
//            child.addSectiionToChild(section1);
//            child.addSectiionToChild(section2);
//            child.addSectiionToChild(section3);
//            session.beginTransaction();
//            session.save(child);
//            session.getTransaction().commit();
//            System.out.println("Done");
            //======================================
//            session.beginTransaction();
//            Section section = session.get(Section.class,9);
//
//            System.out.println(section);
//            System.out.println(section.getChildList());
//            session.getTransaction().commit();
//            System.out.println("Done");
            //============================================
//            session.beginTransaction();
//            Child child = session.get(Child.class,4);
//
//            System.out.println(child);
//            System.out.println(child.getSectionsList());
//            session.getTransaction().commit();
//            System.out.println("Done");
            //===================================

//            session.beginTransaction();
//            Section section = session.get(Section.class,12);
//            session.delete(section);
//            session.getTransaction().commit();
//            System.out.println("Done");

            //================================
            session.beginTransaction();
            Child child = session.get(Child.class,2);
            session.delete(child);
            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            session.close();
            factory.close();
        }
    }
}
