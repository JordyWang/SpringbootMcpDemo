package org.example.mcp.contoller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Resource
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String call(@RequestParam String input) {
        return chatClient.prompt(input).call().content();
    }
}
