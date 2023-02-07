package com.hb14.entity_life_cycle;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
   Entity State :
      *) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.

      *) Persisted or Managed : DB de row a karşılık geldiği durum,
                        save(),get() vs. yapıldığı zamana denk geliyor.

      *) Detached : Session kapandıktan sonra elimizdeki objenin state durumu.

      *) Removed : obje remove yapıldığı zamanki durum.
*/

public class RunnerSave14 {

    public static void main(String[] args) {

        Student14 student1 = new Student14(); // **Transient State***
        student1.setName("Recep Bey");
        student1.setMathGrade(99);

        Student14 student2 = new Student14(); // **Transient State***
        student2.setName("Emir Bey");
        student2.setMathGrade(99);

        Student14 student3 = new Student14(); // **Transient State***
        student3.setName("Recep Bey");
        student3.setMathGrade(99);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        session.save(student1); //***Persisted State***

        student1.setName("Guncellenmis Recep Bey");

        session.evict(student1); //***Detached state e gecti.

        session.update(student1); // detached olmus student1 objesini persisted State e alir.
        session.merge(student1);  // detached olmus student1 objesini persisted State e alir.


        tx.commit();
        session.close();
        sf.close();

    }

}
