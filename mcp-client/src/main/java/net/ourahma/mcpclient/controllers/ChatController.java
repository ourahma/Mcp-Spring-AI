package net.ourahma.mcpclient.controllers;

import net.ourahma.mcpclient.agents.AIAgent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin("*")
public class ChatController {

    private AIAgent aiAgent;

    public ChatController(AIAgent aiAgent) {
        this.aiAgent = aiAgent;
    }

    @GetMapping("/")
    public String index() {
        return "chat";
    }

    @PostMapping("/chat/send")
    public String sendMessage(@RequestParam String query, Model model){
        if (query == null || query.trim().isEmpty()) {
            model.addAttribute("response", "⚠Vous devez saisir un message.");
            return "chat";
        }
        String response= aiAgent.askLLM(query);
        model.addAttribute("response",response);
        return "chat";
    }

}
