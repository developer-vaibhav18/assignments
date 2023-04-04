package com.example.dream11.services;

import com.example.dream11.models.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User createUser(User user);
    public Collection<User> createAllUsers(List<User> users);
    public DeleteResult deleteAllUsers();
    public User getUserByUserId(int userId);
    public DeleteResult deleteUserByUserId(int userId);
    public UpdateResult updateUser(User user);
    public User updateMoneyOfUserById(int userId, float newMoney);
    public User updateContestIdArrayOfUserById(int userId, int contestId);
}
