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
public class UserService {
    @Autowired
    private UserRepository customUserRepository;
    public List<User> getAllUsers() {
        List<User> users = customUserRepository.getAllUsers();
        return users;
    }
    public User addUser(User user) {
        return customUserRepository.addUser(user);
    }

    public Collection<User> addMultipleUsers(List<User> users) {
        Collection<User> addedUsers = customUserRepository.addMultipleUsers(users);
        return addedUsers;
    }

    public DeleteResult deleteAllUsers() {
        return customUserRepository.deleteAllUsers();
    }

    public User getUserByEmail(String email) {
        return customUserRepository.getUserByEmail(email);
    }

    public DeleteResult deleteUserByEmail(String email) {
        return customUserRepository.deleteUserByEmail(email);
    }

    public UpdateResult updateUser(User user) {
        return customUserRepository.updateUser(user);

    }
    public User updateMoneyOfUserByEmail(String email, float newMoney) {
        return customUserRepository.updateMoneyOfUserByEmail(email, newMoney);
    }
    public User UpdateContestIdArrayOfUserByEmail(String email, Integer contestId) {
        return customUserRepository.UpdateContestIdArrayOfUserByEmailDTO(email, contestId);

    }
}
