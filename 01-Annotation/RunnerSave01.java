package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Duhan Ozturk");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Tarik");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Mirac");
        student3.setGrade(70);

        //28-32 arasi kodlar her Hibernate projemizde olacak.
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //Hibernate'e konfigurasyon dosyami ve Entity class'imi bildirdim.
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //session.save(student1);
        //session.save(student2);
        //session.save(student3);

        tx.commit();// tx.commit() yapmazsak; DB'ye bilgilerimiz gitmez.

        session.close();
        sf.close();


    }

}
