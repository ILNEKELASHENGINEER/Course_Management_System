package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Stucr implements Initializable {
    @FXML
    private Button back;
    public void backOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teachstudcr.fxml"));
        Stage stage = (Stage)back.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

    }
    @FXML
    private TableView<crd1> tablecourse;
    @FXML
    private TableColumn<crd1,String> coursename;
    @FXML
    private TableColumn<crd1,String> courseid;
    @FXML
    private TableColumn<crd1,String> facultyname;
    @FXML
    private TableColumn<crd1,String> studentid;
    ObservableList<crd1> crd1ObservableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resource){
    Databaseconnection connectionNow = new Databaseconnection();
    Connection connectDB = connectionNow.getConnection();
    String crdurl = "SELECT `coursename`, `courseid`, `facultyname`, `studentid` FROM `courseregister`";
    try{
        Statement statement = connectDB.createStatement();
        ResultSet queryoutput = statement.executeQuery(crdurl);
        while(queryoutput.next()){
            String crname=queryoutput.getString("coursename");
            String crid=queryoutput.getString("courseid");
            String fname=queryoutput.getString("facultyname");
            String stuid=queryoutput.getString("studentid");
            crd1ObservableList.add(new crd1(crname,crid,fname,stuid));
        }
        //coursename,courseid,facultyname,studentid;
        coursename.setCellValueFactory(new PropertyValueFactory<>("coursename"));
        courseid.setCellValueFactory(new PropertyValueFactory<>("courseid"));
        facultyname.setCellValueFactory(new PropertyValueFactory<>("facultyname"));
        studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        tablecourse.setItems(crd1ObservableList);
    }catch (SQLException e){
        e.printStackTrace();
    }

    }



}
