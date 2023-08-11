//for COURSE ENROLLED

package com.example.demo;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Registeration{
    @FXML
    private Button bckbtn;
    @FXML
    private Button go;
    @FXML
    private TableView<crshow> coursetable;
    @FXML
    private TableColumn<crshow,String> courseid;
    @FXML
    private TableColumn<crshow,String> coursename;
    @FXML    //coursename,courseid,facultyname
    private TableColumn<crshow,String> facultyname;
    @FXML
    private TextField studentid;
    public void bckbtnOnAction(ActionEvent e){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourseDashboard.fxml"));
        Stage stage = (Stage)bckbtn.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }
    public void goOnAction(ActionEvent e){
       // public void initialize(URL url, ResourceBundle resource){
        ObservableList<crshow> crshowObservableList = FXCollections.observableArrayList();
            Databaseconnection connectionNow = new Databaseconnection();
            Connection connectDB = connectionNow.getConnection(); //name,mobileno,dateofb,studentid
            String crurl = "SELECT * FROM  courseregister WHERE studentid = '" + studentid.getText() + "'";
            try{
                Statement statement = connectDB.createStatement();
                ResultSet queryoutput = statement.executeQuery(crurl);
                while(queryoutput.next()){
                    String couname1=queryoutput.getString("coursename");
                    String courseid1=queryoutput.getString("courseid");
                    String faculty1=queryoutput.getString("facultyname");
                    crshowObservableList.add(new crshow(couname1,courseid1,faculty1));
                }
                //coursename,courseid,facultyname
                coursename.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                courseid.setCellValueFactory(new PropertyValueFactory<>("courseid"));
                facultyname.setCellValueFactory(new PropertyValueFactory<>("facultyname"));
                coursetable.setItems(crshowObservableList);
            }catch (SQLException m){
                m.printStackTrace();
            }

        //}
    }


}
