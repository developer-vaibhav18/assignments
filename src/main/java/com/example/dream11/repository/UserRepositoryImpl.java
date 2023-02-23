package com.example.dream11.repository;

import com.example.dream11.models.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@Primary
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public User updateMoneyOfUserByEmail(String email, float newMoney) {
        Query query = new Query(Criteria.where("email").is(email));
        Update updateDefinition = new Update().set("money", newMoney
        );
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().returnNew(true);
        User user = mongoTemplate.findAndModify(query, updateDefinition, findAndModifyOptions, User.class);
        return user;
    }
    @Override
    public User UpdateContestIdArrayOfUserByEmailDTO(String email, int contestId) {
        Query query = new Query(Criteria.where("email").is(email));
        Update updateDefinition = new Update().push("contestIdsInWhichUserParticipated", contestId);
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().returnNew(true);
        User user = mongoTemplate.findAndModify(query, updateDefinition, findAndModifyOptions, User.class);
        if (user == null) System.out.println("No user found!");
        return user;
    }
    @Override
    public UpdateResult updateUser(User user) {
        Query query = new Query(Criteria.where("userId").is(user.getUserId()));
        Update updateDefinition = new Update().set("name", user.getName())
                                              .set("email", user.getEmail())
                                              .set("money", user.getMoney())
                                .set("contestIdsInWhichUserParticipated", user.getContestIdsInWhichUserParticipated());
        UpdateResult updateResult = mongoTemplate.upsert(query, updateDefinition, User.class);
        return updateResult;
    }

    @Override
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User addUser(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public Collection<User> addMultipleUsers(List<User> users) {
        return mongoTemplate.insertAll(users);
    }

    @Override
    public DeleteResult deleteAllUsers() {
        Query query = new Query();
        return mongoTemplate.remove(query, User.class);
    }

    @Override
    public DeleteResult deleteUserByEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        return mongoTemplate.remove(query, User.class);
    }
}
