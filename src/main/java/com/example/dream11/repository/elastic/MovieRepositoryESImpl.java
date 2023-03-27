package com.example.dream11.repository.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.bulk.CreateOperation;
import com.example.dream11.models.elastic.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryESImpl implements MovieRepositoryES {

    @Autowired
    ElasticsearchClient elasticsearchClient;

    @Override
    public SearchResponse<Movie> getAllMovies() throws Exception{
        SearchResponse<Movie> movies = elasticsearchClient.search(s -> s.index("testx_movies"), Movie.class);
        System.out.println(movies);
        return movies;
    }

    @Override
    public BulkResponse addMoviesInBulk(List<Movie> movies) throws Exception{
        List<BulkOperation> bulkOperations = new ArrayList<>();
        for (Movie movie : movies) {
            bulkOperations.add(new CreateOperation.Builder().document(movie).build()._toBulkOperation());
        }
        BulkRequest bulkRequest = new BulkRequest.Builder().index("assignment").operations(bulkOperations).build();
        return elasticsearchClient.bulk(bulkRequest);
    }
}
