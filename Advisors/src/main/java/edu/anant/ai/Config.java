package edu.anant.ai;

import edu.anant.ai.aspect.LoggingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    ChatClient chatClient(
            ChatClient.Builder chatBuilder,
            LoggingAdvisor loggingAdvisor
    ) {

        return chatBuilder
                .defaultAdvisors(loggingAdvisor)
                .build();
    }
}