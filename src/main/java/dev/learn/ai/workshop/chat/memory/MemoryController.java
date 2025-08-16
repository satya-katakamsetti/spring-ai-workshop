package dev.learn.ai.workshop.chat.memory;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoeryController {
    private final ChatClient chatClient;

    public MemoeryController(@Qualifier("openAPIChatClient")ChatClient chatClient,
                             ChatMemory chatMemory) {
        this.chatClient = chatClient.mutate()
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }

    @GetMapping("/memory")
    public String memoery(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call().
    }
}
