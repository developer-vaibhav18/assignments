package com.example.dream11.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDbConfiguration {

    @Bean
    public MongoClient getMongoClient() {
        ConnectionString connectionString = new ConnectionString(
                "mongodb://127.0.0.1:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                                                                     .build();
        return MongoClients.create(mongoClientSettings);
    }
}
