package com.example.dream11.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
public class ChangeDbConfiguration {

    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoTemplate mongoTemplate;

    public void changeDatabaseUri(String uri) {
        mongoClient.close();
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                                                                     .build();
        mongoClient = MongoClients.create(mongoClientSettings);
        mongoTemplate = new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient, "test"));
        System.out.println("changed");
    }
}
