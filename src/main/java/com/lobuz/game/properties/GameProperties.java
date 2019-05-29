package com.lobuz.game.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "game.path")
public class GameProperties {

    private String firstScenePath;
    private String secondScenePath;
    private String thirdScenePath;
}


