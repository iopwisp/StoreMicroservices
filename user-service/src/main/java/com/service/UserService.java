package com.service;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserService(UserRepository repo, KafkaTemplate<String, String> kafkaTemplate) {
        this.userRepository = repo;
        this.kafkaTemplate = kafkaTemplate;
    }

    public User createUser(User user) {
        User saved = userRepository.save(user);
        kafkaTemplate.send("user-created-topic", saved.getUsername());
        return saved;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
