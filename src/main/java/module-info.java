module com.example.f22comp1011s1w1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f22comp1011s1w1 to javafx.fxml;
    exports com.example.f22comp1011s1w1;
}