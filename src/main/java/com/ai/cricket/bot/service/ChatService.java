package com.ai.cricket.bot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatClient chatClient;

    public String getResponse(String request) throws IOException {
        ClassPathResource resource = new ClassPathResource("prompt/system.txt");
        String systemPrompt;
        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            systemPrompt = reader.lines().collect(Collectors.joining("\n"));
        }
        return chatClient.prompt().system(systemPrompt).user(request).call().content();

    }
}
