package com.example.dream11.repository.elastic;

import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.dream11.models.elastic.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositoryES {
    public SearchResponse<Movie> getAllMovies() throws Exception;

    public BulkResponse addMoviesInBulk(List<Movie> movies) throws Exception;
}
