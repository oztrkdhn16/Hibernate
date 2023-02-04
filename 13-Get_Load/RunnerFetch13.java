package com.hb13.get_load;

/*
   get() --->  gerçek nesneyi döndürür ,
               nesne yoksa null döner
               nesnenin olduğundan emin değilseniz get() kullanın
               dönen nesneye hemen kullanacaksam get() kullanılmalı (DB'den veriyi alir gelir.)

   load() -->  proxy nesne döndürür, gerçek nesnenin gölgesi ,
               nesne yoksa exception fırlatır
               dönen nesne üzerinde delete yapılacaksa kullanılabilir (DB'den verinin golgesi gelir.)
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        System.out.println("Get methodunun baslangic yeri");
//        Student13 student1 = session.get(Student13.class,1L);
//        System.out.println("Get methodunun bittigi satir");
//        System.out.println("Student ID: "+ student1.getId());
//        System.out.println("Student get Name: "+ student1.getName());

//        System.out.println("*******************************************");
        //yukaridaki senaryonun aynisini load() methodu ile yapalim.
//        System.out.println("Load methodunun baslangic yeri");
//        Student13 student2 = session.load(Student13.class,2L);
//        System.out.println("getName() cagrildi.");
//        System.out.println("Student2 nin ismi: "+ student2.getName());//***
//        System.out.println("getName() bitti..");
//        System.out.println("Load methodunun bittigi satir");

        //Load'da Select sorgusu gelmiyor. Bu objeyi kullanacagimiz zaman select sorgusu gelir.
        //(***) bu yildizlarin oldu yer oldugu icin load methodunu calistirarak Select sorgusu gelir.
        //(***) bu sorguyu yapmasaydik Select sorgusu yapmayacakti.

        //DB'de olmayan ID'yi cagirirsak?
//        System.out.println("get() methodu calismaya basladi: ");
//        Student13 student3 = session.get(Student13.class,5L);
//        System.out.println("get() methodu bitti");
        //System.out.println("Student ID: "+student3.getId());

        //Olmayan bir datadan bir field'da ulasmak istersek "NullPointerException" aliriz.

//        if (student3!=null){
//            System.out.println("Student ID: "+student3.getId());
//            System.out.println("Student Get Name: "+student3.getName());
//        }

//        System.out.println("**********************************************");
//        System.out.println("Load methodu baslismaya basladi...");
//        Student13 student4 = session.load(Student13.class,10L);
//        System.out.println("Load methodu bitti...");
//
//        if (student4!=null){ //true
//            System.out.println("Student ID: "+student4.getId());
//            System.out.println("Student Get Name: "+student4.getName());
//        }


        // Peki load() Methodunu niye kullanayalim??????

//        Student13 student5 = session.get(Student13.class,1L);
//        session.delete(student5);
        // Load methodu ile obje referansi alinir ve sonra delete cagirilir.
        // Get methodu cagrilmayarak DB'ye hit(database'e sorgu gondermek) engellenmis olur.

        Student13 student6 = session.load(Student13.class,1L);
        session.delete(student6);
        //Getter-Setter kullanmayacaksam sadece silme islemi yapacaksam load kullanilir.


        tx.commit();
        session.close();
        sf.close();

    }
}
