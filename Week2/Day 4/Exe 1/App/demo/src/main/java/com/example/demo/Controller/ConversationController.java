package com.example.demo.Controller;

import com.example.demo.Service.ConversationService;
import com.example.demo.model.Conversation;
import com.example.demo.provider.OpenAIProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;
    private final OpenAIProvider openAIProvider;

 /*    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
        this.openAIProvider = null;
    } */

    @GetMapping("/{userId}")
    public List<Conversation> getAllConversationsByUser(@PathVariable int userId) {
        return conversationService.getAllConversationsByUser(userId);
    }
    
    @Autowired
    public ConversationController(ConversationService conversationService, OpenAIProvider openAIProvider) {
        this.conversationService = conversationService;
        this.openAIProvider = openAIProvider;
    }

  

    // Add more methods to handle other API endpoints related to conversations

    @PostMapping("/ask-openai")
    public String askOpenAI(@RequestBody String prompt) {
        if (openAIProvider == null) {
            return "OpenAIProvider not available";
        }
        return openAIProvider.askOpenAI(prompt);
    }
}
