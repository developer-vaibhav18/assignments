package com.example.dream11.controller;

import co.elastic.clients.elasticsearch.core.BulkResponse;
import com.example.dream11.services.MongoESInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mongoESInteraction")
public class MongoESInteractionController {
    @Autowired
    MongoESInteractionService mongoESInteractionService;
    @PutMapping("/addMoviesInESFromMongo")
    String addMoviesInESFromMongo(@RequestParam int size) throws Exception{
        return mongoESInteractionService.getMoviesFromMongoAndInsertInES(size);
    }
}
