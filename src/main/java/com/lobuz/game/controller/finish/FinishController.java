package com.lobuz.game.controller.finish;

import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FinishController {

    @FXML
    private Button exit;

    @FXML
    public void exitApp(ActionEvent event) {
        System.exit(0);
    }

}
