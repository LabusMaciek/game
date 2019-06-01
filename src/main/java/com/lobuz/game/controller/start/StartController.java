package com.lobuz.game.controller.start;

import com.lobuz.game.config.ApplicationProperties;
import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.entity.QuestionModel;
import com.lobuz.game.dto.service.QuestionServiceImpl;
import com.lobuz.game.properties.GameProperties;
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
public class StartController implements Initializable {

    private final ApplicationProperties properties;
    private final QuestionServiceImpl service;
    private final StageManager stageManager;

    public StartController(ApplicationProperties properties, QuestionServiceImpl service,
                           @Lazy StageManager stageManager) {
        this.properties = properties;
        this.service = service;
        this.stageManager = stageManager;
    }

    @FXML
    private Button startButton;
    @FXML
    private Label startLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startLabel.setText(properties.getWelcomeLabel());
        startButton.setText(properties.getStartButton());
    }

    public void handle(ActionEvent event) {
        List<QuestionModel> list = service.getQuestions();
        log.info("rozmiar: " + list.size());
        stageManager.switchScene(FxmlView.GAME);

    }

}
