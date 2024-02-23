package com.example.demo.Controller;

import com.example.demo.Service.MessageService;
import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PutMapping("/{messageId}")
    public Message updateMessage(@PathVariable int messageId, @RequestBody Message updatedMessage) {
        return messageService.updateMessage(messageId, updatedMessage.getContent(), updatedMessage.getSender());
    }

    // Add more methods to handle other API endpoints related to messages
}
