package edu.anant.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RAGService {

    private final ChatClient chatClient;

    private final VectorStore vectorStore;

    public String generate(
            String userPrompt,
            String userId) {

        // ==============================
        // 1. TEST REDIS VECTOR SEARCH
        // ==============================

        SearchRequest searchRequest =
                SearchRequest.builder()
                        .query(userPrompt)
                        .topK(5)
                        .similarityThresholdAll()
                        .build();

        var documents =
                vectorStore.similaritySearch(searchRequest);

        System.out.println("====================================");
        System.out.println("USER QUERY: " + userPrompt);
        System.out.println("DOCUMENTS FOUND: " + documents.size());
        System.out.println("====================================");

        for (var document : documents) {

            System.out.println("------------------------------------");
            System.out.println(document.getFormattedContent());
            System.out.println("------------------------------------");
        }


        // ==============================
        // 2. RAG ADVISOR
        // ==============================

        QuestionAnswerAdvisor qaAdvisor =
                QuestionAnswerAdvisor
                        .builder(vectorStore)
                        .searchRequest(
                                SearchRequest.builder()
                                        .topK(5)
                                        .similarityThresholdAll()
                                        .build()
                        )
                        .build();


        // ==============================
        // 3. GEMINI + RAG
        // ==============================

        return chatClient
                .prompt()

                .user(userPrompt)

                .advisors(qaAdvisor)

                .advisors(advisor ->
                        advisor.param(
                                ChatMemory.CONVERSATION_ID,
                                userId
                        )
                )

                .call()

                .content();
    }
}