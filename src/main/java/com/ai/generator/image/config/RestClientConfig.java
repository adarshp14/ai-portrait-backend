package com.ai.generator.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(System.getenv("STABLE_DIFFUSION_URL"))
                .defaultHeader("Authorization", "Bearer "+System.getenv("HUGGING_FACE_API_KEY"))
                .build();
    }


}

