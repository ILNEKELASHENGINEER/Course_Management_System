package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
public class CourseDashboard {
@FXML
private Button grades;
@FXML
private Button att;
@FXML
private Button reg;
@FXML
private Button enroll;
@FXML
private Button finalbtn;
@FXML
private Label usrid;
     public void mouseOnAction(MouseEvent e){
         HelloController b=new HelloController();
         usrid.setText(b.x);
     }
    public void enrollOnAction(ActionEvent e){
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registeration.fxml"));
    Stage stage = (Stage)enroll.getScene().getWindow();
    try {
        stage.setScene(new Scene(fxmlLoader.load()));
    }catch (IOException x){
        throw new RuntimeException(x);
    }}
    public void gradesOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("grade.fxml"));
        Stage stage = (Stage)enroll.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }

    }
    public void attOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("attendancepercent.fxml"));
        Stage stage = (Stage)att.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }

    }
    public void regOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("courseregister.fxml"));
        Stage stage = (Stage)reg.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }
    public void finalbtnOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)finalbtn.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }


}
