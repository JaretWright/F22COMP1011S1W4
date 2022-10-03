package com.example.f22comp1011s1w1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SongTableViewController {

    @FXML
    void createSongScene(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "create-song-view.fxml");
    }

}
