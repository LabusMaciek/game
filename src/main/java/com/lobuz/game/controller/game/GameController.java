package com.lobuz.game.controller.game;

import com.lobuz.game.config.ApplicationProperties;
import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.entity.Points;
import com.lobuz.game.dto.entity.QuestionModel;
import com.lobuz.game.dto.service.QuestionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private final QuestionService service;
    private final Points points;
    private final ApplicationProperties properties;

    private final List<QuestionModel> questionList;

    public GameController(@Lazy StageManager stageManager, QuestionService service,
                          List<QuestionModel> questionList, Points points,
                          ApplicationProperties properties) {
        this.stageManager = stageManager;
        this.service = service;
        this.questionList = questionList;
        this.points = points;
        this.properties = properties;
    }

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
        log.info("q: " + questionNumber);
        if (questionNumber > 8) {
            nextStage();
        } else {
            setQuestion(++questionNumber);
        }
    }


    @FXML
    public void checkAnswer(ActionEvent event) {
        String answer = ((Button) event.getSource()).getText();
        points.calculatePoints(answer, questionNumber);
    }


    private void setQuestion(int num) {
        questionField.setText(questionList.get(num).getQuestion());
        answerA.setText(questionList.get(num).getAnswerA());
        answerB.setText(questionList.get(num).getAnswerB());
        answerC.setText(questionList.get(num).getAnswerC());
        answerD.setText(questionList.get(num).getAnswerD());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setQuestion(questionNumber);
    }

    private void nextStage() {
        stageManager.switchScene(FxmlView.FINISH);
    }
}
