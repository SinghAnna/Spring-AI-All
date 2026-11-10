package edu.anant.ai;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class RAG_Service {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public RAG_Service(ChatClient chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }

    public String generate(String userPrompt, String userId) {


        QuestionAnswerAdvisor questionAnswerAdvisor = QuestionAnswerAdvisor.builder(vectorStore)
                .build();

        return chatClient.prompt()
                .user(userPrompt)
        //       RAG
                .advisors(questionAnswerAdvisor)
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID,userId))
                .call()
                .content();

    }
}
