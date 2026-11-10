package edu.anant.ai.advicer;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class LoggingAdviser implements CallAdvisor {
    @Override
    public ChatClientResponse adviseCall(@NonNull ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {

        logRequest(chatClientRequest);
        ChatClientResponse chatClintResponse = callAdvisorChain.nextCall(chatClientRequest);
        logResponse(chatClintResponse);
        return chatClintResponse;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getOrder() {
        return 0;
    }


    private void logResponse(ChatClientResponse clientResponse){
        log.info("Response {}",clientResponse);
    }

    private void logRequest(ChatClientRequest chatClientRequest){
        log.info("Request {}",chatClientRequest);
    }
}
