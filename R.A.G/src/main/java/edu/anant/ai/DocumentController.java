package edu.anant.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPdf(
            @RequestParam("file") MultipartFile file) {

        try {

            documentService.uploadPdf(file);

            return ResponseEntity.ok(
                    "PDF uploaded and indexed successfully"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .internalServerError()
                    .body("Error: " + e.getMessage());
        }
    }
}