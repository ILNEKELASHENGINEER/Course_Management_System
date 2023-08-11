package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Teacherlogin {
    @FXML
    private TextField teacherid;
    @FXML
    private PasswordField teachpass;
    @FXML
    private Button back;
    @FXML
    private Button log;
    @FXML
    private Label loginmessagelabel3;

    public void backOnAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainpage.fxml"));
        Stage stage = (Stage)back.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }

    public void logOnAction(ActionEvent actionEvent) {
        Databaseconnection connection = new Databaseconnection();
        Connection connectDB = connection.getConnection();
        String verifylogin2 = "SELECT * FROM teacherdetail WHERE teacherid = '" + teacherid.getText() + "' AND password = '" + teachpass.getText() + "'";
        // String verifylogin = "SELECT * FROM studentdetail WHERE studentid = '" + studentid.getText() + "' AND password = '" + stupass.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult2 = statement.executeQuery(verifylogin2);

            if(queryResult2.next()) {
//

                //System.out.println(queryResult.getString(1));
                //x = queryResult.getString(1);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teachstudcr.fxml"));
                Stage stage = (Stage) log.getScene().getWindow();
                try {
                    stage.setScene(new Scene(fxmlLoader.load()));
                } catch (IOException x) {
                    throw new RuntimeException(x);
                }
            } else {
                loginmessagelabel3.setText("invalid credentials");
            }
        }
        catch(Exception m){
            m.printStackTrace();
        }
    }
}
