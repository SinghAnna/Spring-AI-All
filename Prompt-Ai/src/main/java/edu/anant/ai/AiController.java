package edu.anant.ai;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;


    @GetMapping("/generate")
    public ResponseEntity<String> generate(@RequestParam String userPrompt){
        return ResponseEntity.status(HttpStatus.OK).body(aiService.generate(userPrompt));
    }

    @GetMapping("/generateStuffData")
    public ResponseEntity<String> generateStuffData(@RequestParam String userPrompt){
        return ResponseEntity.status(HttpStatus.OK).body(aiService.generateStuffData(userPrompt));
    }

    @GetMapping("/generateSupport")
    public ResponseEntity<String> generateSupport(@RequestParam String userPrompt){
        return ResponseEntity.status(HttpStatus.OK).body(aiService.generateSupport(userPrompt));
    }

}
