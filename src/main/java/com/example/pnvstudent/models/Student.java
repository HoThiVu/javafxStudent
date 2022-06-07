package com.example.pnvstudent.models;

public class Student {
    public  int id;
    public  String name;
    public  float score;
    private int id_student;

    public int getId_student() {
        return id_student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public Student(int id, String name, float score,int id_student) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.id_student = id_student;
    }

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }
}
