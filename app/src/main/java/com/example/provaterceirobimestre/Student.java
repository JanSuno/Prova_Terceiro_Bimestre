package com.example.provaterceirobimestre;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private double average;
    private double grade1;
    private double grade2;

    public Student(String name, double average, double grade1, double grade2){
        this.name = name;
        this.average = average;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public String getName(){
        return name;
    }

    public double getGrade1(){
        return grade1;
    }

    public double getGrade2(){
        return  grade2;
    }

    public double getAverage(){
        return average;
    }
}
