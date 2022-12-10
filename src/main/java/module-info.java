module com.example.demoexamtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.demoexamtest to javafx.fxml;
    exports com.example.demoexamtest;
}