package com.lobuz.game.controller.finish;

import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.entity.Points;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Controller
public class FinishController implements Initializable{

    private final Points points;
    private final StageManager stageManager;
    @FXML
    public Button exit;
    @FXML
    public Button replay;
    @FXML
    public Label score;


    public FinishController(Points points, @Lazy StageManager stageManager) {
        this.points = points;
        this.stageManager = stageManager;
    }

    @FXML
    public void playAgain(ActionEvent event) {
        stageManager.switchScene(FxmlView.GAME);

    }

    @FXML
    public void exitApp() {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        score.setText(points.getPoints()+"!");
    }
}
