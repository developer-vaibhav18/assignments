package com.example.dream11.services;

import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.dream11.models.elastic.Movie;
import com.example.dream11.repository.elastic.MovieRepositoryESImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieESService {

    @Autowired
    MovieRepositoryESImpl movieRepositoryES;

    public SearchResponse<Movie> getAllMovies() throws Exception{
        return movieRepositoryES.getAllMovies();
    }
    public BulkResponse insertMoviesInBulk(List<Movie> movies) throws Exception {
        return movieRepositoryES.addMoviesInBulk(movies);
    }
}
