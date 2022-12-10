package com.example.demoexamtest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class MenuScreenController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnHis;

    @FXML
    void initialize() {
        timeline.play();
    }

    public void Exit() throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startScreen.fxml")));
        Stage window = (Stage) btnExit.getScene().getWindow();
        window.setScene(new Scene(parent, 600, 400));
        window.show();
        timeline.stop();
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10000), event -> {
        try {
            Exit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }));

    public void History() throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("historyScreen.fxml")));
        Stage stage = (Stage) btnHis.getScene().getWindow();
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
        timeline.stop();
    }


}
