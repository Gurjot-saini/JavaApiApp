module org.example.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens org.example.assignment3 to javafx.fxml;
    exports org.example.assignment3;
}