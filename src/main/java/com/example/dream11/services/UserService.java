package com.example.dream11.services;

import com.example.dream11.models.User;
import com.example.dream11.repository.CustomUserRepository;
import com.example.dream11.repository.CustomUserRepositoryImpl;
import com.example.dream11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserRepository customUserRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
    public void addUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public void addMultipleUsers(List<User> users) {
        userRepository.insert(users);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User deleteUserByEmail(String email) {
        return userRepository.deleteUserByEmail(email);
    }
    public String updateUser(User user) {
        return customUserRepository.updateUser(user);
    }
    public User updateMoneyOfUserByEmail(String email, float newMoney) {
        return customUserRepository.updateMoneyOfUserByEmail(email, newMoney);
    }
    public User UpdateContestIdArrayOfUserByEmailDTO(String email, Integer contestId) {
        return customUserRepository.UpdateContestIdArrayOfUserByEmailDTO(email, contestId);
    }
}
