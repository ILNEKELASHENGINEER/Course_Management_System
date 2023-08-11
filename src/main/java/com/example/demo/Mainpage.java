package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Mainpage implements Initializable {
    @FXML
    private Label time;
    private volatile boolean stop = false;
    public Button teacherbtn;
    public Button stubtn;
    public Button close;
    public void initialize(URL url, ResourceBundle rb){
        Timenow();
    }
    public void teacherbtnOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) teacherbtn.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    public void stubtnOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Teacherlogin.fxml"));
        Stage stage = (Stage)stubtn.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

    }
    public void closeOnAction(ActionEvent e){
        stop=true;
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
    private void Timenow(){
        Thread thread = new Thread(()->{
            SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
            while(!stop){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("Error in clock");
            }
            final String timenow = sdf.format(new Date());
                Platform.runLater(()->{
                    time.setText(timenow);
                });
            }
        });
        thread.start();
    }
}
