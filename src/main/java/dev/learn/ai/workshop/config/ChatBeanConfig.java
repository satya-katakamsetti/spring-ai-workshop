package dev.learn.ai.workshop.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.openai.OpenAiChatModel;

@Configuration
public class ChatBeanConfig {

    @Bean
    public ChatClient openAPIChatClient(OpenAiChatModel chatModel){
        return ChatClient.create(chatModel);
    }

    @Bean
    public ChatClient deepSeekChatClient(DeepSeekChatModel chatModel){
        return ChatClient.create(chatModel);
    }
}
