package net.ourahma.mcpclient.controllers;

import net.ourahma.mcpclient.agents.AIAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIRestController {
    private AIAgent aiAgent;

    AIRestController(AIAgent aiAgent) {
        this.aiAgent = aiAgent;
    }

    @GetMapping("/chat")
    public String chat(String query){
        return aiAgent.askLLM(query);
    }
}
