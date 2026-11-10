package edu.anant.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;

    public AiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String generate(String userPrompt) {
        return chatClient
                .prompt()
                .user(userPrompt)
                .call()
                .content();
    }
}
