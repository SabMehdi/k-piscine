package com.example.demo.Service;

import com.example.demo.model.Conversation;
import com.example.demo.model.User;
import com.example.demo.repository.ConversationRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository, UserRepository userRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
    }

    public Conversation createConversation(Conversation conversation) {
        int userId = conversation.getUser().getUserId();
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist");
        }

        conversation.setUser(user);
        return conversationRepository.save(conversation);
    }

    public Conversation getConversationById(int conversationId) {
        return conversationRepository.findById(conversationId).orElse(null);
    }

    public boolean doesUserExist(int userId) {
        return userRepository.existsById(userId);
    }
}
