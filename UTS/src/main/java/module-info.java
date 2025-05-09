module com.example.uts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uts to javafx.fxml;
    exports com.example.uts;
}