package com.example.dream11.repository;

import com.example.dream11.models.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository {
     public User updateMoneyOfUserByUserId(int userId, float money);
     public User UpdateContestIdArrayOfUserByUserId(int userId, int id);
     public UpdateResult updateUser(User user);
     public List<User> getAllUsers();
     public User getUserByUserId(int userId);
     public User addUser(User user);
     public Collection<User> addMultipleUsers(List<User> users);
     public DeleteResult deleteAllUsers();
     public DeleteResult deleteUserByUserId(int userId);
}
