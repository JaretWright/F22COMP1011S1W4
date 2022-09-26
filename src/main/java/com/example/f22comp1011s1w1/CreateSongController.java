package com.example.f22comp1011s1w1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
    void createSong(ActionEvent event) {
        //when the submit button is pushed, create a Song object
        Song newSong = new Song(nameTextField.getText(),
                                genreComboBox.getValue(),
                                Integer.parseInt(lengthTextField.getText()),
                                yearSpinner.getValue(),
                                artistComboBox.getValue());
        resultLabel.setText(newSong.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Artist artist1 = new Artist("Alfred","Jackson", LocalDate.of(1987,10,11));
        Artist artist2 = new Artist("Jack","Johnson", LocalDate.of(1997,01,8));

        artistComboBox.getItems().add(artist1);
        artistComboBox.getItems().add(artist2);

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
}
