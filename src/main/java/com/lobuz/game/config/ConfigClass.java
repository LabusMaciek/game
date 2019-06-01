package com.lobuz.game.config;

import java.io.IOException;
import java.util.List;

import com.lobuz.game.dto.entity.QuestionModel;
import com.lobuz.game.dto.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javafx.stage.Stage;

@Slf4j
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
    public StageManager stageManager(Stage stage) throws IOException {
        return new StageManager(springFXMLLoader, stage);
    }

    @Bean
    public List<QuestionModel> getList() {
        return service.getQuestions();

    }
}
