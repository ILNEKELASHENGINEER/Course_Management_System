package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Teachstudcr {
    @FXML
    private Button stucr;
    @FXML
    private Button stupr;
    @FXML
    private Button logout;
    public void stucrOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stucr.fxml"));
        Stage stage = (Stage) stucr.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    public void stuprOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stupr.fxml"));
        Stage stage = (Stage) stupr.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

    }
    public void logoutOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainpage.fxml"));
        Stage stage = (Stage) logout.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

    }

}
