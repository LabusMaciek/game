package com.lobuz.game.controller.game;

import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.entity.QuestionModel;
import com.lobuz.game.dto.ranking.model.Points;
import com.lobuz.game.dto.service.Clock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


@Controller
public class GameController implements Initializable {

    private static int questionNumber = 0;
    private final StageManager stageManager;
    private final Points points;
    private static String answer = "";
    private final List<QuestionModel> questionList;

    public GameController(@Lazy StageManager stageManager,
                          List<QuestionModel> questionList, Points points) {
        this.stageManager = stageManager;
        this.questionList = questionList;
        this.points = points;
    }

    @FXML
    private Label questionField;
    @FXML
    private RadioButton answerA = new RadioButton();
    @FXML
    private RadioButton answerB;
    @FXML
    private RadioButton answerC;
    @FXML
    private RadioButton answerD;
    @FXML
    private ToggleGroup radioButtonGroup;

    @FXML
    public void next() {

        points.calculatePoints(answer, questionNumber);
        questionNumber++;
        if (questionNumber >= 9) {
            questionNumber = 0;
            nextStage();
        } else {
            setQuestion(questionNumber);
        }
    }


    public void checkAnswer(ActionEvent event) {
        answer = ((RadioButton) event.getSource()).getText();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setQuestion(questionNumber);
        Clock clock = new Clock(new GameController(stageManager, questionList, points));
        Thread thread = new Thread(clock);
        thread.start();
    }
}
