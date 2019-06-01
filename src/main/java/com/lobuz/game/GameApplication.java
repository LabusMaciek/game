package com.lobuz.game;

import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.lobuz.game.config.FxmlView;
import com.lobuz.game.config.StageManager;

@SpringBootApplication
public class GameApplication extends Application {

    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {

        SpringApplicationBuilder builder = new SpringApplicationBuilder(GameApplication.class);
        String[] args = getParameters().getRaw().toArray(new String[0]);
        context = builder.run(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StageManager stageManager = context.getBean(StageManager.class, primaryStage);
        stageManager.switchScene(FxmlView.START);
    }

    @Override
    public void stop() {
        context.close();
    }
}
