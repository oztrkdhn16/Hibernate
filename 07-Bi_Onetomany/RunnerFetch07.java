package com.hb07.bi_onetomany;

import com.hb06.uni_onetomany.Book06;
import com.hb06.uni_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get() methodu
//        Student07 student = session.get(Student07.class, 1001);
//        student.getBookList().forEach(System.out::println); //Method referance
        //student.getBookList().forEach(b-> System.out.println(b)); // lambda expression

        // SQL ile ogrenci bilgilerini alalim ( ogrenci isimi ve kitap ismi)
//        String sqlQuery = "SELECT s.student_name, b.name FROM Student07 s Inner Join  Book07 b on s.id=b.student_id";
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
//
//        for(Object[] object: resultList1){
//            System.out.println(Arrays.toString(object));
//        }

        // Yukaridaki sorguyu HQL ile yazalim
//        String hqlQuery = "SELECT s.name, b.name FROM Student07 s Inner Join  Book07 b on s.id=b.student";
//        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
//
//        for(Object[] object: resultList2){
//            System.out.println(Arrays.toString(object));
//        }

        //Not: Once Book'taki verileri silip Sonra Ogrenciler'deki verileri silmeliyiz.
        //     Cunku child'da verileri silmeden Parent silemeyiz.


        // Delete islemi SQL
//        String sqlQuery2 = "DELETE FROM book07";
//        int numberOfDeleteRecords = session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Silinen kayit sayisi: "+ numberOfDeleteRecords);

        // Delete islemi SQL
//        String sqlQuery3 = "DELETE FROM student07";
//        int numberOfDeleteRecords2 = session.createSQLQuery(sqlQuery3).executeUpdate();
//        System.out.println("Silinen kayit sayisi: "+ numberOfDeleteRecords2);

        // Delete islemi HQL
//        String hqlQuery2 = "DELETE FROM Book07";
//        int numberOfDeleteRecords3 = session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("Silinen kayit sayisi: "+ numberOfDeleteRecords3);

        // Delete islemi HQL
//        String hqlQuery3 = "DELETE FROM Student07";
//        int numberOfDeleteRecords4 = session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println("Silinen kayit sayisi: "+ numberOfDeleteRecords4);

        //Kitap ismi "A Book" olan kitabi siliniz. HQL ile
//        String hqlQuery4 = "DELETE FROM Book07 b WHERE b.name = 'A Book'";
//        int numberOfDeleteRecords5 = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Silinen kayit sayisi: "+ numberOfDeleteRecords5);

        //Kitap bilgisi olan bir ogrenciyi silmek istersek bunun 2 yolu var:

            //1) Once Book tablosundan iliskili oldugu Book'lar silinir daha sonra istenen
            //   student objesi silinebilir.

            //2) Student entity class'inin ilgili yerine Cascade / orphanRemoval


        //1001 ID'li student objemi delete metoduyla silelim.
//        Student07 student = session.get(Student07.class,1001);
//        session.delete(student);

        // student.getBookList().set(0,null); //orphanRemovel=ture; 0. indexdeki child'i Child tablosundan gider siler.

        // book ismi icinde "Java" gecen student kayitlarini alalim. (HQL)

        String hqlQuery5 = "Select s From Student07 s JOIN s.bookList b WHERE b.name LIKE '%Java%'";
        List<Student07> resultList1 = session.createQuery(hqlQuery5,Student07.class).getResultList();

        for(Student07 student07: resultList1){
            System.out.println(student07);
        }



        tx.commit();
        session.close();
        sf.close();

    }

}
