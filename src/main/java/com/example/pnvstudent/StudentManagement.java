package com.example.pnvstudent;
import com.example.pnvstudent.data.DBConnection;
import com.example.pnvstudent.models.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class StudentManagement extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage Scene) {
        DBConnection db = new DBConnection();
//        ArrayList<Student> stdList = db.getStudents();
//        System.out.println("size : " + stdList.size());
//        db.insertStudent(new Student("lan",5));
//        db.updataStudent(new Student(2 ,"ho thi h",9));
//        db.deleteStudent(2);
        VBox root = new VBox();

        VBox formVbox = new VBox();

//        VBox root = new VBox();
        HBox rootHbox = new HBox();
        Label lbID = new Label("ID : ");
        Label lbName = new Label("Name : ");
        Label lbScore= new Label("Score : ");
        Button btnSave = new Button("Save");
        TextField textFieldID = new TextField("Nhap ID");
        TextField textFieldName = new TextField("Nhap Name");
        TextField textFieldScore = new TextField("Nhap Score");
        Label lbTextID = new Label("ID");
        Label lbTextName = new Label("Name");
        Label lbTextScore = new Label("Score");
        rootHbox.getChildren().addAll(lbTextID,lbTextName,lbTextScore);

        formVbox.getChildren().addAll(lbID,textFieldID,lbName,textFieldName,lbScore,textFieldScore,btnSave,rootHbox);

        textFieldID.setMaxWidth(250);
        textFieldName.setMaxWidth(250);
        textFieldScore.setMaxWidth(250);
//        rootHbox.setSpacing(25);

//        root.getChildren().addAll(rootHbox);
        root.getChildren().addAll(formVbox);
        getDisplayStudents(root,db,textFieldID,textFieldName,textFieldScore);

        Scene.setScene(new Scene(root, 1000, 600));
        Scene.show();
    }
void getDisplayStudents(VBox vBox,DBConnection db, TextField textFieldID,TextField textFieldName,TextField textFieldScore){
    ArrayList<Student> stdList = db.getStudents();
            System.out.println("size : " + stdList.size());

    System.out.println("size : " + stdList.size());
    VBox add = new VBox();
    for (int i = 0; i<stdList.size(); i++){
        HBox hBoxStudents = new HBox();
//        HBox hBoxCongcu =new HBox();
        Button btnEdit = new Button("EDIT");
        hBoxStudents.setSpacing(10);

        Label lbID = new Label(" "+ stdList.get(i).id);
        Label lbName= new Label(""+ stdList.get(i).name);
        Label lbScore = new Label(" "+ stdList.get(i).score);
        Button btnDel = new Button(" DELETE");
        int finalI = i;
        btnDel.setOnAction(e->{
            db.deleteStudent(stdList.get(finalI).id);

            vBox.getChildren().remove(vBox.getChildren().get(1));
            getDisplayStudents(vBox,db,textFieldID,textFieldName,textFieldScore);
        });
        btnEdit.setOnAction(e->{
            textFieldID.setText(String.valueOf(stdList.get(finalI).id));
            textFieldName.setText(String.valueOf(stdList.get(finalI).name));
            textFieldScore.setText(String.valueOf(stdList.get(finalI).score));
//            getDisplayStudents(vBox,db,textFieldID,textFieldName,textFieldScore);
        });

//        hBoxCongcu.getChildren().addAll();
        hBoxStudents.getChildren().addAll(lbID,lbName,lbScore,btnDel,btnEdit);
        add.getChildren().add(hBoxStudents);
    }
    vBox.getChildren().add(add);
    System.out.print(vBox.getChildren());
    }

}
    //ham get student tra ve mot list student
