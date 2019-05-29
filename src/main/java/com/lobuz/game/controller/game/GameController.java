package com.lobuz.game.controller.game;

import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GameController {

    private static int num = 0;
    @FXML
    private Label questionField;
    @FXML
    private Button nextButton;
    @FXML
    private Button backButton;
    @FXML
    private Button answerA;
    @FXML
    private Button answerB;
    @FXML
    private Button answerC;
    @FXML
    private Button answerD;

    @FXML
    public void next(ActionEvent event) {
        num++;
        log.info("num: " + num);
        if (num > 2) {
            log.info("dziala przewijanie");
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/finish/finish.fxml"));
                Scene scene = new Scene(root);
                Stage gameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                gameStage.setScene(scene);
                gameStage.show();

            } catch (Exception e) {
                log.error("Error during switch scene, ", e);
            }

        }
    }
}

