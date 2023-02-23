package com.example.dream11.repository;

import com.example.dream11.models.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    @Query("{email:'?0'}")
    public User findUserByEmail(String email);
    @DeleteQuery("{email:?0}")
    public User deleteUserByEmail(String email);
}
