package dev.learn.ai.workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekChatClient {
    private final ChatClient chatClient;

    public DeepSeekChatClient(@Qualifier("deepSeekChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
