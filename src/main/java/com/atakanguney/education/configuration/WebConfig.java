package com.atakanguney.education.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ApplicationRestControllerAdvice restControllerAdvice() {
        return new ApplicationRestControllerAdvice();
    }
}
