package dev.learn.ai.workshop.chat.multimodel;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageDetectionController {
    private final ChatClient chatClient;
    @Value("classpath:/static/temple.jpg")
    private Resource sampleImage;

    public ImageDetectionController(@Qualifier("openAPIChatClient") ChatClient chatClient){
        this.chatClient = chatClient;
    }

    @GetMapping("/image-to-text")
    public String imageToText() {
        return chatClient.prompt()
                .user(u -> {
                    u.text("can you please describe, which you see in the following image? also tell me location if know");
                    u.media(MimeTypeUtils.IMAGE_JPEG,sampleImage);
                })
                .call()
                .content();
    }
}
