package com.example.demo;

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
import java.util.ResourceBundle;

public class grade implements Initializable {
    @FXML
    private Button bck;
    @FXML
    private Label rangra;
    public void bckOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourseDashboard.fxml"));
        Stage stage = (Stage)bck.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int a = 70;
        int b = 99;
        int random_int = (int)Math.floor(Math.random() * (b - a + 1) + a);
        rangra.setText(Integer.toString(random_int));
    }

}
