package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
        Image image = new Image("G:\\malarneke\\demo\\src\\main\\java\\com\\example\\demo\\online-learning.png");
        stage.getIcons().add(image);
        stage.setTitle("Course Management System");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
