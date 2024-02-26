package com.example.demo.Service;

import com.example.demo.model.Message;
import com.example.demo.provider.OpenAIProvider; // Import OpenAIProvider
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final OpenAIProvider openAIProvider; // Inject OpenAIProvider

    @Autowired
    public MessageService(MessageRepository messageRepository, OpenAIProvider openAIProvider) {
        this.messageRepository = messageRepository;
        this.openAIProvider = openAIProvider;
    }

    public Message createMessage(Message message) {
        // Process the message content using OpenAIProvider
        String processedContent = openAIProvider.askOpenAI(message.getContent());
        message.setContent(processedContent);
        
        // Save the processed message to the database
        return messageRepository.save(message);
    }
}
