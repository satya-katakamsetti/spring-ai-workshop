package dev.learn.ai.workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekChatController {
    private final ChatClient chatClient;

    public DeepSeekChatController(@Qualifier("deepSeekChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
