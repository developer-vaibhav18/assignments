package com.example.dream11.services;

import com.example.dream11.models.User;
import com.example.dream11.repository.UserRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return users;
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public Collection<User> createAllUsers(List<User> users) {
        Collection<User> createdUsers = userRepository.createAllUsers(users);
        return createdUsers;
    }

    public DeleteResult deleteAllUsers() {
        return userRepository.deleteAllUsers();
    }

    public User getUserByUserId(int userId) {
        return userRepository.getUserByUserId(userId);
    }

    public DeleteResult deleteUserByUserId(int userId) {
        return userRepository.deleteUserByUserId(userId);
    }

    public UpdateResult updateUser(User user) {
        return userRepository.updateUser(user);

    }

    public User updateMoneyOfUserById(int userId, float newMoney) {
        return userRepository.updateMoneyOfUserByUserId(userId, newMoney);
    }

    public User updateContestIdArrayOfUserById(int userId, int contestId) {
        return userRepository.updateContestIdArrayOfUserByUserId(userId, contestId);
    }
}
