package com.example.dream11.repository.mongo;

import com.example.dream11.models.mongo.MongoMovie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MovieRepositoryMongoImpl implements MovieRepositoryMongo {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<MongoMovie> getAllMovies() {
        return mongoTemplate.findAll(MongoMovie.class);
    }

    @Override
    public List<MongoMovie> getMoviesWithPageRequest(PageRequest pageRequest) {
        Query query = new Query().with(pageRequest);
        List<MongoMovie> movies = mongoTemplate.find(query, MongoMovie.class);
        return movies;
    }
}
