package com.ai.generator.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://api-inference.huggingface.co/models/stabilityai/stable-diffusion-3.5-large")
                .defaultHeader("Authorization", "Bearer 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")
                .build();
    }


}

