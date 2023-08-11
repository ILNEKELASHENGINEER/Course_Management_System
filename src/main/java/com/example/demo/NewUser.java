package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class NewUser {
    @FXML
    private Button cancel;
    @FXML
    private Button submit;
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
    @FXML
    private TextField emailid;
    @FXML
    private TextField mobile;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private Label passerror;
    public void cancelOnAction(ActionEvent e) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage)cancel.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        }catch (IOException x){
            throw new RuntimeException(x);
        }
    }
   // Connection con;
   // PreparedStatement pst;
    public void submitOnAction(ActionEvent e){
        Databaseconnection connectNow = new Databaseconnection();
        Connection connectDB = connectNow.getConnection();
        String name1 = name.getText();
        String dob1 = dob.getText();
        String emailid1 = emailid.getText();
        String mobile1 = mobile.getText();
        String pass1 = password1.getText();
        String pass2 = password2.getText();
     //  if(name.getText().isBlank()==false && dob.getText().isBlank()==false && emailid.getText().isBlank()==false&& password1.getText().isBlank()==false && password2.getText().isBlank()==false){
          //if(pass1.equals(pass2)){
                try{
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course","root","root");
                   String pst = "INSERT INTO studentdetail(name,mobileno,dateofb,studentid,password) VALUES ('" +name1+ "','" +dob1+ "','" +emailid1+ "','" +mobile1+ "','" +pass1+ "')";
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(pst);
//                    con.close();
//                    pst.close();
                    name.setText("");
                    password1.setText("");
                    emailid.setText("");
                    mobile.setText("");
                    dob.setText("");
                    password2.setText("");

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("User Created Successfully--you can go to login page");

                        alert.showAndWait();
                       // statement

                }
                catch (Exception m){
                    //System.out.println("Error occured new user");
                    m.printStackTrace();
                }

            }
//            else{
//                Alert alert1 = new Alert(Alert.AlertType.ERROR);
//                alert1.setContentText("Enter the same password in re-enter password field");
//                alert1.showAndWait();
//            }
//        }

    }
//}
