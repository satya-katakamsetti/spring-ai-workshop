package dev.learn.ai.workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(@Qualifier("openAPIChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(){
        return chatClient.prompt()
                .user("Tell me an interesting fact about java")
                .call().content();
    }

    @GetMapping("/stream")
    public Flux<String> stream(){
        return chatClient.prompt()
                .user("I'm visiting Hilton Head soon, can you give me 10 places I must visit?")
                .stream()
                .content();
    }

    @GetMapping("/joke")
    public ChatClientResponse jok(){
        return chatClient.prompt()
                .user("tell me a joke!")
                .call().chatClientResponse();
    }
}
