package com.example.dream11.services;

import com.example.dream11.models.elastic.Movie;
import com.example.dream11.models.mongo.MongoMovie;
import com.example.dream11.repository.mongo.MovieRepositoryMongoImpl;
import com.example.dream11.util.es.ConvertMongoMovieToElasticMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MongoESInteractionService {
    @Autowired
    MovieRepositoryMongoImpl movieRepositoryMongo;
    @Autowired
    MovieESService movieESService;
    public String getMoviesFromMongoAndInsertInES(int size) throws Exception{
        PageRequest pageRequest = PageRequest.ofSize(size);
        Date startDate = new Date();
        while (true) {
            List<MongoMovie> mongoMovies = movieRepositoryMongo.getMoviesWithPageRequest(pageRequest);
            Date cur = new Date();
            System.out.println("call for mongodb ends at " + (cur.getTime() - startDate.getTime()) / 1000);
            if (mongoMovies.size() == 0) break;
            List<Movie> movies = new ArrayList<>();
            mongoMovies.forEach(mongoMovie -> movies.add(ConvertMongoMovieToElasticMovie.convertMongoMovieToElasticMovie(mongoMovie)));
            movieESService.insertMoviesInBulk(movies);
            cur = new Date();
            System.out.println("call for inserting in ES ends at " + (cur.getTime() - startDate.getTime()) / 1000);
            pageRequest = pageRequest.next();
            cur = new Date();
        }
        return "done";
    }
}
