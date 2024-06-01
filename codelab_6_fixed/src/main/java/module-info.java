module com.example.codelab_6_fixed {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codelab_6_fixed to javafx.fxml;
    exports com.example.codelab_6_fixed;
}