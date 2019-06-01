package com.lobuz.game.controller.game;

import com.lobuz.game.config.ApplicationProperties;
import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.entity.Points;
import com.lobuz.game.dto.entity.QuestionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Slf4j
@Controller
public class GameController implements Initializable {

    private static int questionNumber = 0;
    private final StageManager stageManager;
    private final Points points;
    private static String answer ="";

    private final List<QuestionModel> questionList;

    public GameController(@Lazy StageManager stageManager,
                          List<QuestionModel> questionList, Points points,
                          ApplicationProperties properties) {
        this.stageManager = stageManager;
        this.questionList = questionList;
        this.points = points;
    }

    @FXML
    private Label questionField;
    @FXML
    private Button next;
    @FXML
    private RadioButton answerA = new RadioButton();
    @FXML
    private RadioButton answerB;
    @FXML
    private RadioButton answerC;
    @FXML
    private RadioButton answerD;
    @FXML
    private ToggleGroup radioButtonGroup = new ToggleGroup();


    @FXML
    public void next(ActionEvent event) {
        log.info("q: " + questionNumber);

        points.calculatePoints(answer, questionNumber);

        if (questionNumber > 2) {
            questionNumber = 0;
            nextStage();
        } else {
            setQuestion(++questionNumber);
        }
    }


    public void checkAnswer(ActionEvent event) {
        answer = ((RadioButton) event.getSource()).getText();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setQuestion(questionNumber);
    }

    private void nextStage() {
        stageManager.switchScene(FxmlView.FINISH);
    }

    private void setQuestion(int num) {
        questionField.setText(questionList.get(num).getQuestion());
        answerA.setText(questionList.get(num).getAnswerA());
        answerB.setText(questionList.get(num).getAnswerB());
        answerC.setText(questionList.get(num).getAnswerC());
        answerD.setText(questionList.get(num).getAnswerD());
    }
}
