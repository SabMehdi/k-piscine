package com.example.demo.model;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conversationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startedAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    // getters and setters
}