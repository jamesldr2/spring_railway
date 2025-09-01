package me.dio.spring_railway.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.spring_railway.domain.model.User;
import me.dio.spring_railway.domain.repositories.UserRepository;
import me.dio.spring_railway.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("User ID already exists");
        }

        return userRepository.save(userToCreate);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

}
