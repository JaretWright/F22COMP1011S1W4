module com.example.f22comp1011s1w1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.f22comp1011s1w1 to javafx.fxml;
    exports com.example.f22comp1011s1w1;
}