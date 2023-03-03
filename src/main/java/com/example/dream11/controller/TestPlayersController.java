package com.example.dream11.controller;

import com.example.dream11.models.SizeOfArray;
import com.example.dream11.models.SizeOfArrayWithSkill;
import com.example.dream11.models.TestPlayers;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestPlayersController {

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/create")
    public TestPlayers createTestPlayer(@RequestBody TestPlayers testPlayers) {
        return mongoTemplate.insert(testPlayers);
    }

    @GetMapping("/getPlayersWithNullSkillsValues")
    public List<TestPlayers> getPlayersWithNullSkills() {
        Query query = new Query(Criteria.where("skills").type(10));
        return mongoTemplate.find(query, TestPlayers.class);
    }

    @GetMapping("/getPlayersWithNoSkills")
    public List<TestPlayers> getPlayersWithNoSkills() {
        Query query = new Query(Criteria.where("skills").exists(false));
        return mongoTemplate.find(query, TestPlayers.class);
    }

    @GetMapping("/getPlayersWithEmptySkillsValues")
    public List<TestPlayers> getPlayersWithEmptySkillsValues() {
        Query query = new Query(Criteria.where("skills").size(0));
        return mongoTemplate.find(query, TestPlayers.class);
    }

    @GetMapping("/getPlayersWithSomeSkillsValues")
    public List<TestPlayers> getPlayersWithSomeSkillsValues() {
        Query query = new Query(Criteria.where("skills").ne(null).not().size(0));
        return mongoTemplate.find(query, TestPlayers.class);
    }

    @GetMapping("/getPlayerWithBattingPrimarySkill")
    public List<TestPlayers> getPlayerWithBattingPrimarySkill() {
        Query query = new Query(Criteria.where("skills").elemMatch(
                Criteria.where("skillName").is("batting").andOperator(Criteria.where("primary").is(true)))).collation(
                Collation.of("en").strength(Collation.ComparisonLevel.tertiary()));
        return mongoTemplate.find(query, TestPlayers.class);
    }

    @GetMapping("/getSkillsArraySize")
    public List<SizeOfArray> getSkillsArraySize() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("skills").exists(true).ne(null)),
                Aggregation.project("name").and("skills").size().as("size"));
        AggregationResults<SizeOfArray> results = mongoTemplate.aggregate(
                aggregation, TestPlayers.class, SizeOfArray.class);
        System.out.println(results.getRawResults());
        return results.getMappedResults();
    }

    @GetMapping("/getSkillsArraySizeWithPrimarySkill")
    public Document getArraySizeWithSkill() {
        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.project("name", "skills", "_id"),
                Aggregation.unwind("skills"),
                Aggregation.match(Criteria.where("skills.primary").is(true)),
                Aggregation.group("_id").first("skills.skillName").as("primarySkill").first("name").as("name")
//                Aggregation.project( "_id")
        );
        AggregationResults<String> results = mongoTemplate.aggregate(aggregation, TestPlayers.class, String.class);
        return results.getRawResults();
    }
}
