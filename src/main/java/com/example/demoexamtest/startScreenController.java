package com.example.demoexamtest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class startScreenController {
    @FXML
    private Button btn;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label errorLabel;


    public void goToMenu() throws IOException, SQLException, ClassNotFoundException {
        String loginText = loginField.getText();
        String passText = passField.getText();

        if (!loginText.equals("")  && !passText.equals("")){
            dbConnect dbHandler = new dbConnect();
            ResultSet result = dbHandler.getUser(loginText,passText);
            int count = 0;
            while (true){
                if (!result.next())
                    break;
                count++;
            }
            if (count >= 1){
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuScreen.fxml")));
                Stage window = (Stage) btn.getScene().getWindow();
                window.setScene(new Scene(parent, 600, 400));
                window.show();
            }else
                errorLabel.setText("Неверные данные");
        }else
            errorLabel.setText("Не все поля заполнены");
    }


}