package com.example.demo.Controller;

import com.example.demo.Service.ConversationService;
import com.example.demo.model.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<?> createConversation(@RequestBody Conversation conversation) {
        int userId = conversation.getUser().getUserId();
        if (!conversationService.doesUserExist(userId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with ID " + userId + " does not exist");
        }


        Conversation createdConversation = conversationService.createConversation(conversation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConversation);
    }

    @GetMapping("/{conversationId}")
    public Conversation getConversationById(@PathVariable int conversationId) {
        return conversationService.getConversationById(conversationId);
    }
}
