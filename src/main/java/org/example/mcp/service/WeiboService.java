package org.example.mcp.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeiboService {

    @Tool(description = "获取微博热搜")
    public String getWeiboHotSearch() {
        return RestClient.create()
                .get()
                .uri("http://shanhe.kim/api/za/weibo.php")
                .retrieve()
                .body(String.class);
    }
}