package com.hb01.annotation;

import javax.persistence.*;

// @Entity annotation'i koydugumuz sinifi DB'de bir tabloya karsilik getirir.
@Entity
@Table(name="t_student01") //DB'de tablo ismim "t_student01" olarak degisti.
public class Student01 { // DB'ye gider "student01" isminde tablo olusturur.

    @Id // primary-key olusmasini sagliyor, Zorunlu alan ****
    // @Column(name="std_id")
    private int id;

    // @Column zorunlu degil ancak customize edebilmek icin gerekli.
    @Column(name="student_name",length = 100, nullable = false, unique = false)
    private String name;

    //@Transient // DB'deki tabloda "grade" adinda bir kolon olusmasini engeller.
    private int grade;

//    @Lob // ---> large object ile buyuk boyutlu datalar tutulabilir.
//    private byte[] image;

    //Getter-Setter ***********************

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

    //to-String() ****************

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
