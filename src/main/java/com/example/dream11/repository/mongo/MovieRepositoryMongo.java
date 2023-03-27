package com.example.dream11.repository.mongo;

import com.example.dream11.models.mongo.MongoMovie;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositoryMongo {
    public List<MongoMovie> getAllMovies();
    public List<MongoMovie> getMoviesWithPageRequest(PageRequest pageRequest);
}
