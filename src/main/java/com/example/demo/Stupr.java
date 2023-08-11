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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Stupr implements Initializable {
    @FXML
    private Button back;

    public void backOnAction(ActionEvent e)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teachstudcr.fxml"));
        Stage stage = (Stage) back.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    @FXML
    private TableView<prd1> protable;
    @FXML
    private TableColumn<prd1,String> studentid;
    @FXML
    private TableColumn<prd1,String> studentname;
    @FXML
    private TableColumn<prd1,String> dateofbirth;
    @FXML
    private TableColumn<prd1,String> mobileno;
    ObservableList<prd1> prd1ObservableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resource){
        Databaseconnection connectionNow = new Databaseconnection();
        Connection connectDB = connectionNow.getConnection(); //name,mobileno,dateofb,studentid
        String prdurl = "SELECT `name`, `mobileno`, `dateofb`, `studentid` FROM `studentdetail`";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryoutput = statement.executeQuery(prdurl);
            while(queryoutput.next()){
                String stname1=queryoutput.getString("name");
                String mobileno1=queryoutput.getString("mobileno");
                String dateofb1=queryoutput.getString("dateofb");
                String studid1=queryoutput.getString("studentid");
                prd1ObservableList.add(new prd1(stname1,mobileno1,dateofb1,studid1));
            }
            //name,mobileno,dateofb,studentid
            studentname.setCellValueFactory(new PropertyValueFactory<>("name"));
            mobileno.setCellValueFactory(new PropertyValueFactory<>("mobileno"));
            dateofbirth.setCellValueFactory(new PropertyValueFactory<>("dateofb"));
            studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
            protable.setItems(prd1ObservableList);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
