package com.example.dream11.controller;

import com.example.dream11.repository.mongo.MovieRepositoryMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import com.example.dream11.models.mongo.MongoMovie;

import java.util.List;

@RestController
@RequestMapping("/movie/mongo")
public class MovieMongoController {
    @Autowired
    private MovieRepositoryMongoImpl movieRepositoryMongo;
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/getMovieWithSize")
    public List<MongoMovie> getMoviesWithPageAndSize(@RequestParam int size) {
        PageRequest pageRequest = PageRequest.ofSize(size);
        return movieRepositoryMongo.getMoviesWithPageRequest(pageRequest);
    }
    @GetMapping("getAllMovies")
    public List<MongoMovie> getAllMovies() {
        return movieRepositoryMongo.getAllMovies();
    }

//    @PutMapping("changeYearDataType")
//    public void changeYearDataType() {
//        List<MongoMovie> mongoMovies = movieRepositoryMongo.getAllMovies();
//        for (MongoMovie movie : mongoMovies) {
//            String year = movie.getYear();
//            if (year.length() > 4) {
//                year = year.replaceAll("[^0-9]", " ");
//                year = year.trim();
//                if (year.length() > 4) {
//                    year = year.substring(0, 4);
//                }
//                Query query = new Query(Criteria.where("_id").is(movie.get_id()));
//                Update update = new Update().set("year", year);
//                mongoTemplate.findAndModify(query, update, MongoMovie.class);
//            }
//        }
//    }
}
