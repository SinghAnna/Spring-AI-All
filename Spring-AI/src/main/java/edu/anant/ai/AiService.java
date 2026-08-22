package edu.anant.ai;

import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

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

    public Flux<String> generateStream(String userPrompt){
        return chatClient.prompt()
                .user(userPrompt)
                .stream()
                .content();
    }

    public @Nullable ChatResponse generateChat(String userPrompt){

        return chatClient.prompt()
                .user(userPrompt)
                .call()
                .chatResponse();
    }


//
//    public Flux<ChatResponse> generateJson(String userPrompt) {
//        return chatClient
//                .prompt()
//                .user(userPrompt)
//                .stream()
//                .chatResponse();
//    }

    public Countries generateJson(String userPrompt){

        return chatClient.prompt()
                .user(userPrompt)
                .call()
                .entity(Countries.class);
    }
}