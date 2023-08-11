package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class courseregister implements Initializable{
    public TextField studid;
    public TextField facultyname;
    public TextField courseid;
    @FXML
    private ChoiceBox<String> mychoicebox;
    private String[] course={"Java","Python","Web development","Cyber Security","Machine Learning"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mychoicebox.getItems().addAll(course);
    }
    @FXML
    Button enroll;
    public void enroll(ActionEvent event) throws IOException, SQLException {
        Databaseconnection connectNow = new Databaseconnection();
        Connection connectDB = connectNow.getConnection();
        String stud = studid.getText();
        String facul = facultyname.getText();
        String course = courseid.getText();
        String choice = mychoicebox.getValue();
        try{
        String pst = "INSERT INTO courseregister(coursename,courseid,facultyname,studentid) VALUES ('" +choice+ "','" +course+ "','" +facul+ "','" +stud+ "')";
        Statement statement = connectDB.createStatement();
        statement.executeUpdate(pst);}
        catch (Exception e){
            e.printStackTrace();
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CourseDashboard.fxml"));
        Parent root = loader.load();
        Scene scene2 = new Scene(root);
        Stage stage = (Stage) enroll.getScene().getWindow();
        stage.setScene(scene2);
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
              alert1.setContentText("You are SUCCESSFULLY enrolled");
             alert1.showAndWait();
    }
    @FXML
    private Button backo;
    public void backoOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourseDashboard.fxml"));
        Stage stage = (Stage)backo.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
        Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setContentText("Your process CANCELLED");
        alert1.showAndWait();
    }
}