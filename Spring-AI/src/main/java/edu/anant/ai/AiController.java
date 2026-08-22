package edu.anant.ai;



import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/generate")
    public String generate(@RequestParam String userPrompt) {
        return aiService.generate(userPrompt);
    }

    @GetMapping("/generateStream")
    public ResponseEntity<Flux<String>> generateStream(@RequestParam String userPrompt){

        return ResponseEntity.status(HttpStatus.OK).body(aiService.generateStream(userPrompt));

    }

    @GetMapping("/generate-chat")
    public ResponseEntity<ChatResponse> generateCharResponse(@RequestParam String userPrompt){
        return ResponseEntity.status(HttpStatus.OK).body(aiService.generateChat(userPrompt));
    }

//    @GetMapping(value = "/generate-chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<ChatResponse> generateChat(@RequestParam String userPrompt) {
//        return aiService.generateJson(userPrompt);
//    }


    @GetMapping("/generate-json")
    public ResponseEntity<Countries> generateJson(@RequestParam String userPrompt){
        return ResponseEntity.status(HttpStatus.OK).body(aiService.generateJson(userPrompt));
    }
}
