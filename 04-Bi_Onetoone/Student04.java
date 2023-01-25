package com.hb04.bi_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {

    @Id
    private int id; //private Long id;

    @Column(name="std_name")
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student") // sadece Diary tablosunda iliski icin yeni bir Kolon olusmasini sagliyor.
    //Bunu yapmamizdaki amac Diary Class'inda olusturdugumuz student parametresinin bu class'da da colon olusmasini
    //istemedigimizden dolayi yapiyoruz.
    private Diary04 diary;

    //Getter-Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    //toString()

    //Method ciktisinda sonsuz donguye girilmesin diye diary objesi eklemedik.(RunnerFetch04)
    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                //", diary=" + diary +
                '}';
    }
}

