package dev.learn.ai.workshop.tools.datetime;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeController {
    private final ChatClient chatClient;

    public DateTimeController(@Qualifier("openAPIChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/tools")
    public String tools() {
        return chatClient.prompt()
                .user("what is tommorow's date?")
                .tools(new DateTimeTools())
                .call()
                .content();
    }
}
