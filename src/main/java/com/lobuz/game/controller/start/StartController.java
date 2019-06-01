package com.lobuz.game.controller.start;

import com.lobuz.game.config.ApplicationProperties;
import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;
import com.lobuz.game.dto.ranking.model.Name;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.Getter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Controller
public class StartController implements Initializable {

    private final ApplicationProperties properties;
    private final StageManager stageManager;

    public StartController(ApplicationProperties properties, @Lazy StageManager stageManager) {
        this.properties = properties;
        this.stageManager = stageManager;
    }

    @FXML
    private Button startButton;
    @FXML
    private Label startLabel;
    @FXML
    private TextField input;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startLabel.setText(properties.getWelcomeLabel());
        startButton.setText(properties.getStartButton());
    }

    @FXML
    public void handle() {
        Name name = new Name();
        name.setName(input.getText());
        stageManager.switchScene(FxmlView.GAME);
    }

}
