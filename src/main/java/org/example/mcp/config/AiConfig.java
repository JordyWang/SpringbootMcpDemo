package org.example.mcp.config;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AiConfig {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Resource
    private SyncMcpToolCallbackProvider toolCallbackProvider;

    @Bean
    public ChatClient chatClient() {
        return ChatClient.builder(ollamaChatModel).defaultTools(toolCallbackProvider.getToolCallbacks()).build();
    }

}
