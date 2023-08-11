
package com.example.demo;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class HelloController {
    Tempuser m = new Tempuser();
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private Button cancel;
    @FXML
    private Button go;
    @FXML
    private Label loginmessagelabel2;
    @FXML
    private TextField studentid;
    @FXML
    private PasswordField stupass;
    @FXML
    private TextField teacherid;
    @FXML
    private PasswordField teachpass;

    public String x = "niki";

    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");

//    }
    public void loginOnAction(ActionEvent e) {

        if (studentid.getText().isBlank() == false && stupass.getText().isBlank() == false) {
            m.id = studentid.getText();
            validateLogin();
        } //else if (teacherid.getText().isBlank() == false && teachpass.getText().isBlank() == false) {
            //validateLogin();
        //}
        else {
            invalid.setText("");
            loginmessagelabel2.setText("Please fill all the fields");

        }

    }
@FXML
private Label invalid;
    public void cancelOnAction(ActionEvent e) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainpage.fxml"));
        Stage stage = (Stage) cancel.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }

    public void signupOnAction(ActionEvent m) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-user.fxml"));
        Stage stage = (Stage) signup.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

    }

    public void goOnAction(ActionEvent e) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Teacherlogin.fxml"));
        Stage stage = (Stage)go.getScene().getWindow();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

    }

    private void validateLogin() {
        loginmessagelabel2.setText("");
        Databaseconnection connection = new Databaseconnection();
        Connection connectDB = connection.getConnection();
       // String verifylogin2 = "SELECT * FROM teacherdetail WHERE teacherid = '" + teacherid.getText() + "' AND password = '" + teachpass.getText() + "'";
        String verifylogin = "SELECT * FROM studentdetail WHERE studentid = '" + studentid.getText() + "' AND password = '" + stupass.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);

            if (queryResult.next()) {
//

                System.out.println(queryResult.getString(1));
                x = queryResult.getString(1);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourseDashboard.fxml"));
                Stage stage = (Stage) signup.getScene().getWindow();
                try {
                    stage.setScene(new Scene(fxmlLoader.load()));
                } catch (IOException x) {
                    throw new RuntimeException(x);
                }
            } else {
                invalid.setText("Invalid credentials");

            }
            //invalid.setText("");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

