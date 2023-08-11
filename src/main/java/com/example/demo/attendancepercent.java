package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class attendancepercent implements Initializable {
    @FXML
    private Button backbtn;
    @FXML
    private Label ranper;
    public void backOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourseDashboard.fxml"));
        Stage stage = (Stage)backbtn.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int a = 50;
        int b = 100;
        int random_int = (int)Math.floor(Math.random() * (b - a + 1) + a);
        ranper.setText(Integer.toString(random_int));
    }
}
