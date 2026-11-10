package edu.anant.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final VectorStore vectorStore;

    public void uploadPdf(MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("PDF file is empty");
        }

        InputStreamResource resource =
                new InputStreamResource(file.getInputStream());

        // PDF -> Documents
        PagePdfDocumentReader reader =
                new PagePdfDocumentReader(resource);

        List<Document> documents = reader.read();

        System.out.println("Pages read: " + documents.size());

        // Documents -> Chunks
        TokenTextSplitter textSplitter =
                TokenTextSplitter.builder()
                        .build();

        List<Document> chunks =
                textSplitter.apply(documents);

        System.out.println("Chunks created: " + chunks.size());

        // Chunks -> Embeddings -> Redis
        vectorStore.add(chunks);

        System.out.println("Documents stored in Redis Vector Store");
    }
}