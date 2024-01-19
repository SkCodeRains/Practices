package com.coderains.learnspringframework.learnspringFramwork6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public String name() {
        return "Coderains";
    }
}
