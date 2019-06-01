package com.lobuz.game.controller.finish;

import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.ranking.mapper.RankingService;
import com.lobuz.game.dto.ranking.model.Name;
import com.lobuz.game.dto.ranking.model.Points;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Controller
public class FinishController implements Initializable {

    private final Points points;
    private final StageManager stageManager;
    private final RankingService rankingService;
    @FXML
    public Button exit;
    @FXML
    public Button replay;
    @FXML
    public Label score;


    public FinishController(Points points, @Lazy StageManager stageManager, RankingService rankingService) {
        this.points = points;
        this.stageManager = stageManager;
        this.rankingService = rankingService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        score.setText(points.getPoints() + "");
        scoreAnimation();
        updateRanking();
    }

    private void updateRanking() {
        Name name = new Name();
        rankingService.saveRecord(name.getName(), points.getPoints());
        name.setName("");
    }

    @FXML
    public void playAgain() {
        stageManager.switchScene(FxmlView.GAME);
    }

    @FXML
    public void exitApp() {
        System.exit(0);
    }

    private void scoreAnimation() {

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setToX(100);
        transition.setByX(100);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(score);
        transition.play();
    }


}
