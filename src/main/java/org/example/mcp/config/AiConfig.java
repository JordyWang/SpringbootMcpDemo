package org.example.mcp.config;

import jakarta.annotation.Resource;
import org.example.mcp.service.WeiboService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AiConfig {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Resource
    private SyncMcpToolCallbackProvider toolCallbackProvider;

    @Bean
    public ToolCallbackProvider weiboTools(WeiboService weiboService) {
        return  MethodToolCallbackProvider.builder().toolObjects(weiboService).build();
    }


    @Bean
    public ChatClient chatClient() {
        return ChatClient.builder(ollamaChatModel).defaultTools(toolCallbackProvider.getToolCallbacks()).build();
    }

}
