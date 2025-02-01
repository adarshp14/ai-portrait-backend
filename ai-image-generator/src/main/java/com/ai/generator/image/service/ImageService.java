package com.ai.generator.image.service;

import com.ai.generator.image.dto.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;

@Service
public class ImageService {

    private static final String HUGGING_FACE_API_URL = "https://api-inference.huggingface.co/models/CompVis/stable-diffusion-v1-4";
    private static final String API_TOKEN = "YOUR_HUGGING_FACE_API_TOKEN";

    private final RestClient restClient;

    @Autowired
    public ImageService(RestClient restClient) {
        this.restClient = restClient;
    }

    public byte[] generateImage(String prompt) {
        ImageRequest request = new ImageRequest(prompt);

        return restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(byte[].class);
    }

}
