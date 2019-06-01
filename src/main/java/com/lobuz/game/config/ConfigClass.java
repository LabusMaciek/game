package com.lobuz.game.config;

import com.lobuz.game.dto.entity.QuestionModel;
import com.lobuz.game.dto.service.QuestionService;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Configuration
public class ConfigClass {

    public ConfigClass(SpringFXMLLoader springFXMLLoader, QuestionService service) {
        this.springFXMLLoader = springFXMLLoader;
        this.service = service;
    }

    private final SpringFXMLLoader springFXMLLoader;
    private final QuestionService service;

    @Bean
    @Lazy
    public StageManager stageManager(Stage stage) {
        return new StageManager(springFXMLLoader, stage);
    }

    @Bean
    public List<QuestionModel> getList() {
        return service.getQuestions();

    }
}
