package com.lobuz.game;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GameApplication extends Application {

    private ConfigurableApplicationContext context;
    private StageManager stageManager;

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
        stageManager = context.getBean(StageManager.class, primaryStage);
        stageManager.switchScene(FxmlView.LOGIN);
    }



    @Override
    public void stop() {
        context.close();
    }
}
