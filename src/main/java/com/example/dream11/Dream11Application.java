package com.example.dream11;

import com.example.dream11.repository.mongo.UserRepository;
import com.example.dream11.repository.mongo.UserRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = "com.example.dream11.repository")
public class Dream11Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Dream11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
