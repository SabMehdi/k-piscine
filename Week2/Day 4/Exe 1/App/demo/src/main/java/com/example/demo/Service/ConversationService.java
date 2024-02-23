package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Conversation;
import com.example.demo.repository.ConversationRepository;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation updateConversation(int conversationId, LocalDateTime newStartedAt) {
        Optional<Conversation> optionalConversation = conversationRepository.findById(conversationId);
        if (optionalConversation.isPresent()) {
            Conversation conversation = optionalConversation.get();
            conversation.setStartedAt(newStartedAt);
            return conversationRepository.save(conversation);
        } else {
            // Handle the case where the conversation with given conversationId doesn't exist
            return null;
        }
    }
    public List<Conversation> getAllConversationsByUser(int userId) {
        return conversationRepository.findByUser_UserId(userId);
    }

}
