package edu.anant.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/rag")
@RequiredArgsConstructor
public class RAGController {

    private final RAGService ragService;

    @GetMapping("/generate")
    public ResponseEntity<String> generate(

            @RequestParam String userPrompt,

            @RequestParam String userId) {

        String response =
                ragService.generate(
                        userPrompt,
                        userId
                );

        return ResponseEntity.ok(response);
    }
}