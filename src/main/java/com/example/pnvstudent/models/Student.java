package com.example.pnvstudent.models;

public class Student {
    public  int id;
    public  String name;
    public  float score;

    public Student(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }
}
