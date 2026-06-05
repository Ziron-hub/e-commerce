package com.ecommerce.user.service;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import com.ecommerce.user.kafka.UserEventProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository repository;

    @Inject
    UserEventProducer eventProducer;

    @Transactional
    public void addUser(User user) {
        if (user.password == null || user.password.isBlank()) {
            throw new IllegalArgumentException("Senha obrigatória na criação do usuário");
        }

        user.setPassword(user.password);
        user.createdAt = LocalDateTime.now();
        repository.persist(user);
        eventProducer.sendEvent("User adicionado: " + user.email);
    }

    @Transactional
    public void removeUser(Long userId) {
        boolean deleted = repository.deleteById(userId);
        if (deleted) {
            eventProducer.sendEvent("User removed with id: " + userId);
        } else {
            eventProducer.sendEvent("User not found with id: " + userId);
        }
    }

    @Transactional
    public void updateUser(Long userId, User updatedUser) {
        // Verifica se o objeto traz um id diferente do path
        if (updatedUser.id != null && !updatedUser.id.equals(userId)) {
            throw new IllegalArgumentException("ID do path e do corpo não conferem");
        }

        User existingUser = repository.findById(userId);
        if (existingUser != null) {
            existingUser.name = updatedUser.name;
            existingUser.email = updatedUser.email;

            if (updatedUser.password != null && !updatedUser.password.isBlank()) {
                existingUser.setPassword(updatedUser.password);
            }

            repository.persist(existingUser);
            eventProducer.sendEvent("User atualizado com id: " + userId);
        } else {
            eventProducer.sendEvent("User não encontrado com id: " + userId);
        }
    }

    public User findUserById(Long userId) {
        return repository.findById(userId);
    }
}
