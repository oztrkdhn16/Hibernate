package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //DB'den bilgi almak icin 3 Yol:
            // 1. get()
            // 2. SQL
            // 3. HQL

        //1. YOL ******************************************************************
//        Student01 student1 = session.get(Student01.class, 1001);
//        Student01 student2 = session.get(Student01.class, 1002);
//        Student01 student3 = session.get(Student01.class, 1003);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);

        //2. YOL ******************************************************************
//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList =  session.createSQLQuery(sqlQuery).getResultList();
//        for(Object[] object: resultList){
//            System.out.println(Arrays.toString(object));
//        }

        //3.YOL ******************************************************************
        // Trick : HQL sorgusunda FROM'dan sonra sinif ismi kullanilmali
//        String hqlQuery = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery, Student01.class).getResultList();
//        for(Student01 student01: resultList2){
//            System.out.println(student01);
//        }


        // uniqueResult() with SQL ***********************************************************************
        // Donecek kaydin unique(tek bir tane) oldugundan emin iseniz uniqueResult() methodu kullanilabilir.

//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name = 'Tarik'";
//        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(uniqueResult1));
//
//        //Yukarida 1 obje gelecek ama icinde kolonlar oldugu icin array turunde obje geldi.
//        System.out.println(uniqueResult1[0] + " : " + uniqueResult1[1] + " : " + uniqueResult1[2]);

        // uniqueResult() with HQL ***********************************************************************
//        String hqlQuery2 = "FROM Student01 WHERE name='Tarik'";
//        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(uniqueResult2);

        //************************************************************************************************
        // Yukaridaki sorguyu HQL Alias kullanarak yapalim.
//        String hqlQuery3 = "FROM Student01 std WHERE std.name='Mirac'";
//        Student01 uniqueResult3 = session.createQuery(hqlQuery3,Student01.class).uniqueResult();
//        System.out.println(uniqueResult3);

        //************************************************************************************************
        // Grade degeri 90 olan ogrenciyi getirelim.
        String hqlQuery4 = "SELECT s.id,s.name FROM Student01 s WHERE s.grade = 90"; //Student01 --> s
        List<Object[]> resultList3 = session.createQuery(hqlQuery4).getResultList();
        // createQuery metoduna tek parametre girdiğimiz için Student01 class'ı ile map'leme işlemi yapılmadı
        // bu yüzden Object olarak aldık.

        for(Object[] object: resultList3){
            System.out.println(Arrays.toString(object));
        }


        tx.commit();

        session.close();
        sf.close();
    }

}
