package com.example.f22comp1011s1w1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("create-song-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Songs R Us!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        Artist artist1 = new Artist("Alfred","Jackson", LocalDate.of(1987,10,11));
//        Artist artist2 = new Artist("Jack","Johnson", LocalDate.of(1997,01,8));
//
//        System.out.println("artist 1: "+artist1);
//        System.out.println("artist 2: "+artist2);

        launch();
    }
}