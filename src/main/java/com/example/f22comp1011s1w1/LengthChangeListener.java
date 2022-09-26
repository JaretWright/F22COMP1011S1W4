package com.example.f22comp1011s1w1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class LengthChangeListener implements ChangeListener<String> {

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String oldValue,
                                                                String newValue) {
        try{
            Integer.parseInt(newValue);
        } catch (Exception e)
        {
            System.out.println(newValue + " had a non numeric value in it");
        }
    }
}
