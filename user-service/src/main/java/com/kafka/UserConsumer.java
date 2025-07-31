package com.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class UserConsumer {

    @KafkaListener(topics = "user-created-topic", groupId = "user-group")
    public void handleUserCreated(String username) {
        System.out.println("User created: " + username);
    }
}
