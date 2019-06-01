package com.lobuz.game.controller.finish;

import com.lobuz.game.dto.entity.Points;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Controller
public class FinishController implements Initializable {

    private final Points points;

    @FXML
    private Button exit;

    public FinishController(Points points) {
        this.points = points;
    }

    @FXML
    public void exitApp(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exit.setText("" + points.getPoints());
    }
}
