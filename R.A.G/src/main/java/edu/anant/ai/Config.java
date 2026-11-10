package edu.anant.ai;



import edu.anant.ai.adviser.LoggerAdviser;
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
            LoggerAdviser loggerAdviser,
            MessageChatMemoryAdvisor messageChatMemoryAdvisor) {

        return chatBuilder
                .defaultSystem("""
                You are a helpful AI assistant.

                Answer questions using the provided knowledge base context.

                If the answer cannot be found in the knowledge base,
                clearly say that the information is not available
                in the knowledge base.

                Do not make up information.
                """)
                .defaultAdvisors(
                        loggerAdviser,
                        messageChatMemoryAdvisor
                )
                .build();
    }


    @Bean
    MessageChatMemoryAdvisor messageChatMemoryAdvisor(ChatMemory chatMemory){
        return MessageChatMemoryAdvisor
                .builder(chatMemory)
                .build();
    }

    @Bean
    ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository){

        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(jdbcChatMemoryRepository)
                .maxMessages(200)
                .build();
    }

    @Bean
    JdbcChatMemoryRepository jdbcChatMemoryRepository(JdbcTemplate jdbcTemplate){
        return JdbcChatMemoryRepository
                .builder()
                .jdbcTemplate(jdbcTemplate)
                .build();
    }





}
