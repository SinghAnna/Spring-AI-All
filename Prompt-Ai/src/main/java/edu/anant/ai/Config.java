package edu.anant.ai;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
     ChatClient chatClient(ChatClient.Builder chatBuilder){
         return chatBuilder.build();
     }
}
