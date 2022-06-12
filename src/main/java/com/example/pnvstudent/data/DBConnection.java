package com.example.pnvstudent.data;
import com.example.pnvstudent.models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {
    private Connection connection;
    public DBConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pnstudent", "root", "");
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Student> getStudents(){
    ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try {
            ResultSet st = connection.prepareStatement(sql).executeQuery();
            while (st.next()){
//                System.out.println("id: " + st.getInt("id"));
//                System.out.println("name: " + st.getString("name"));
//                System.out.println("score: " + st.getFloat("score"));
                Student std = new Student(
                        st.getInt("id"),
                        st.getString("name"),
                        st.getFloat("score")
                        );
                list.add(std);
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertStudent(Student std){
        String sql = "INSERT INTO students (name, score,id_student) VALUES ('"+ std.name + "',"+ std.score+ ","+std.id+")";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
            System.out.println("them mot hoc sinh thanh cong !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
public  void updataStudent(Student std){
        String  sql = "UPDATE students SET name = '"+ std.name +"',score = "+ std.score+" WHERE id = "+std.id+"";
        System.out.println(sql);
    try {
        connection.prepareStatement(sql).executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
public void deleteStudent(int id){
        String sql =" DELETE FROM students WHERE id = "+ id + "";
        System.out.println(sql);
        try {
        connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}}



