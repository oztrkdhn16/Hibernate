package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get Methodu
//        Student06 student = session.get(Student06.class,1001);
//        System.out.println(student);

        // HQL ile id si 101 olan kitabi getirelim
//        String hqlQuery = "FROM Book06 b Where b.id=101";
//
//        Book06 book1 = session.createQuery(hqlQuery,Book06.class).uniqueResult();
//        System.out.println(book1);

        //Bir ogrencinin kitaplarini ogrenci id'ye gore getirme

//        String hqlQuery2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
//        List<Object[]> resultList = session.createQuery(hqlQuery2).getResultList();
//        for(Object[] object: resultList){
//            System.out.println(Arrays.toString(object));
//        }


        //get() ile bir ogrencinin kitaplarini ogrenci id'ye gore getirme
        Student06 student = session.get(Student06.class,1001);
        System.out.println(student.getBookList());


        tx.commit();
        sf.close();
        session.close();


    }

}
