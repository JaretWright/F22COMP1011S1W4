package com.example.f22comp1011s1w1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateSongController implements Initializable {

    @FXML
    private ComboBox<Artist> artistComboBox;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Spinner<Integer> yearSpinner;

    @FXML
    void createSong(ActionEvent event) throws SQLException {
        //when the submit button is pushed, create a Song object
        Song newSong = new Song(nameTextField.getText(),
                                genreComboBox.getValue(),
                                Integer.parseInt(lengthTextField.getText()),
                                yearSpinner.getValue(),
                                artistComboBox.getValue());

        //This line will add the new song object to the DB and return the songID
        int songID = DBUtility.insertSongDB(newSong);
        resultLabel.setText("Added to DB with songID =" + songID);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artistComboBox.getItems().addAll(DBUtility.getArtistsFromDB());
        genreComboBox.getItems().addAll(Song.getGenres());

//        LengthChangeListener lcl = new LengthChangeListener();
        //This is a lambda expression
        lengthTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try{
                if (!newValue.isBlank())
                    Integer.parseInt(newValue);
            }catch (Exception e)
            {
                lengthTextField.setText(oldValue);
            }
        });

        //configure the Spinner
        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.
                                            IntegerSpinnerValueFactory(1900,LocalDate.now().getYear(),
                                                                        2000);
        yearSpinner.setValueFactory(spinnerValueFactory);
        yearSpinner.setEditable(true);
        TextField spinnerTextField = yearSpinner.getEditor();
        spinnerTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try{
                if (!newValue.isBlank())
                    Integer.parseInt(newValue);
            }catch (Exception e)
            {
                spinnerTextField.setText(oldValue);
            }
        });

        resultLabel.setText("");
    }

    @FXML
    private void changeToTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "song-table-view.fxml");
    }
}
