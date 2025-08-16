package dev.learn.ai.workshop.chat.rag;

import dev.learn.ai.workshop.chat.record.Models;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagController {
    private final ChatClient chatClient;

    public RagController(@Qualifier("openAPIChatClient") ChatClient chatClient,
                         VectorStore vectorStore) {
        this.chatClient = chatClient.mutate()
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @GetMapping("/rag/models")
    public Models faq(@RequestParam (defaultValue = "Give me a list of all the models from OpenAI along with their context window.") String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .entity(Models.class);
    }
}
