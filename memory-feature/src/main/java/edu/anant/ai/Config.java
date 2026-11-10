package edu.anant.ai;

import edu.anant.ai.advicer.LoggingAdviser;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Config {

    @Bean
    ChatClient chatClient(
            ChatClient.Builder chatBuilder,
            LoggingAdviser loggingAdviser,
            MessageChatMemoryAdvisor messageChatMemoryAdvisor) {

        return chatBuilder
                .defaultAdvisors(loggingAdviser)
                .defaultAdvisors(messageChatMemoryAdvisor)
                .build();
    }

    @Bean
    MessageChatMemoryAdvisor messageChatMemoryAdvisor(ChatMemory chatMemory) {

        return MessageChatMemoryAdvisor
                .builder(chatMemory)
                .build();
    }

    @Bean
    ChatMemory chatMemory(
            JdbcChatMemoryRepository jdbcChatMemoryRepository) {

        return MessageWindowChatMemory
                .builder()
                .chatMemoryRepository(jdbcChatMemoryRepository)
                .maxMessages(100)
                .build();
    }

    @Bean
    JdbcChatMemoryRepository jdbcChatMemoryRepository(
            JdbcTemplate jdbcTemplate) {

        return JdbcChatMemoryRepository
                .builder()
                .jdbcTemplate(jdbcTemplate)
                .build();
    }
}