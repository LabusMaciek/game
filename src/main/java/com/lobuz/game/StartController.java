package com.lobuz.game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class StartController {

    @FXML
    public Button button;

    @FXML
    public VBox vBox;

    private final StageManager stageManager;


    public StartController(@Lazy StageManager stageManager) {
        this.stageManager = stageManager;
    }
}
