package com.lobuz.game.controller.start;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.lobuz.game.properties.GameProperties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StartController implements Initializable {

    private final GameProperties properties;
    @FXML
    public Button startButton;
    @FXML
    public Label startLabel;

    public StartController(GameProperties properties) {
        this.properties = properties;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startLabel.setText("space quiz");
        startLabel.setWrapText(true);
        startButton.setText("start game");
    }

    public void handle(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource(properties.getSecondScenePath()));
            Scene scene = new Scene(root);
            Stage gameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            gameStage.setScene(scene);
            gameStage.show();

        } catch (Exception e) {
            log.error("Error during switch scene, ", e);
        }

    }

}
