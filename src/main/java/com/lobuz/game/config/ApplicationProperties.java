package com.lobuz.game.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "game.view")
public class ApplicationProperties {

    private String welcomeLabel;
    private String startButton;

}
