package com.hb11.criteriaapi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class RunnerFetch11 {

    public static void main(String[] args) {

        /*

            CRUD (Create, Read, Update, Delete)

                C ---> session.save
                R ---> session.get, HQL, SQL
                U ---> session.update, updateQuery
                D ---> session.delete, HQL, SQL

                Spring Boot'da gorecegiz JPQL. Projelerde siklikla kullaniliyor. HQL benziyor farkedilmiyor bile.

         */


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student11 student = session.get(Student11.class,1L);
//        student.setName("Guncellenmis "+ student.getName());
//        session.update(student);

        //Degisken Tanimlama
//        int sMathGrade = 80;
//        int lMathGrade = 75;
//
//        String hqlQuery = "UPDATE Student11 s SET s.mathGrade =:sMath WHERE s.mathGrade<:lMath";
//        Query query = session.createQuery(hqlQuery);
//
//        query.setParameter("sMath",sMathGrade);
//        query.setParameter("lMath",lMathGrade);
//        int numberOfRecords = query.executeUpdate();
//        System.out.println("Degistirilen Kayit Sayisi: "+numberOfRecords);

        //CriteriaAPI *********************

        //Bu 3 satiri yazmamiz gerekli.
        CriteriaBuilder cb = session.getCriteriaBuilder();//Criteria objesi olusturuyoruz.(Interface turunde degisken elde ediyoruz)
        CriteriaQuery<Student11> criteriaQuery =  cb.createQuery(Student11.class);//Criteria uzerinden createQuery olusturuyoruz.
        Root<Student11> root = criteriaQuery.from(Student11.class);//Yukarida 2 satir aslinda root objesine ulasabilmek.(Amac)

        //1.Ornek
//        criteriaQuery.select(root);
//        Query<Student11> query1 = session.createQuery(criteriaQuery);
//        List<Student11> resultList = query1.getResultList();
//        resultList.forEach(s-> System.out.println(s));

        //2.Ornek: Student ismi "Student Name: 6" olan ogrenci bilgilerini getirelim.
//        criteriaQuery.select(root). //Select * From student11
//                where(cb.equal(root.get("name"),"Student Name: 6"));
//        Query<Student11> query2 = session.createQuery(criteriaQuery);
//        List<Student11> resultList2 = query2.getResultList();
//        resultList2.forEach(s-> System.out.println(s));

        //3.Ornek: mathGrade degeri 80'den buyuk olan datalari getirelim
//        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
//        Query<Student11> query3 = session.createQuery(criteriaQuery);
//        List<Student11> resultList3 = query3.getResultList();
//        resultList3.forEach(s-> System.out.println(s));

        //4.Ornek: MathGrade degeri 95 den kucuk olan datalar
//        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),95));
//        Query<Student11> query4 = session.createQuery(criteriaQuery);
//        List<Student11> resultList4 = query4.getResultList();
//        resultList4.forEach(s-> System.out.println(s));

        //5.Ornek: Id'si 1 veya mathGrade'i 75 den buyuk olan recordu bulalim.

        Long id = 1L;

        Predicate predicateFoId = cb.equal(root.get("id"),id);
        Predicate predicateFoMathGrade = cb.greaterThan(root.get("mathGrade"),75);

        Predicate predicateQuery = cb.or(predicateFoId,predicateFoMathGrade);

        criteriaQuery.where(predicateQuery);
        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultList5 = query5.getResultList();
        resultList5.forEach(s-> System.out.println(s));


        tx.commit();
        session.close();
        sf.close();

    }


}
