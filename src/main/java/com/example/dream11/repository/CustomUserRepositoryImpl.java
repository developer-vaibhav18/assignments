package com.example.dream11.repository;

import com.example.dream11.models.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CustomUserRepositoryImpl implements CustomUserRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public User updateMoneyOfUserByEmail(String email, float newMoney) {
        Query query = new Query(Criteria.where("email").is(email));
        Update updateDefinition = new Update().set("money", newMoney);
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().returnNew(true);
        User user = mongoTemplate.findAndModify(query, updateDefinition, findAndModifyOptions, User.class);
        if (user == null) System.out.println("No user found!");
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
    public String updateUser(User user) {
        Query query = new Query(Criteria.where("userId").is(user.getUserId()));
        Update updateDefinition = new Update().set("user", user);
        UpdateResult updateResult = mongoTemplate.upsert(query, updateDefinition, User.class);
        if (updateResult.getUpsertedId() != null)
            return "New Document inserted with id = " + updateResult.getUpsertedId().toString();
        return "No new document is inserted";
    }
}
