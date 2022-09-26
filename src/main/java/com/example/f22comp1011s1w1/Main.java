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
           launch();
    }
}