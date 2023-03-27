package com.example.dream11.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import com.example.dream11.models.elastic.Movie;
import com.example.dream11.repository.elastic.MovieRepositoryES;
import com.example.dream11.services.MovieESService;
import com.example.dream11.util.es.ConvertorFromSearchResponseToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieESController {
    @Autowired
    MovieESService movieESService;
//    @Autowired
//    ElasticsearchClient elasticsearchClient;
//    @DeleteMapping("/deleteIndex")
//    public void deleteIndexFromES(@RequestParam String indexName) throws Exception{
//        DeleteIndexResponse deleteIndexResponse =
//                elasticsearchClient.indices().delete(new DeleteIndexRequest.Builder().index(indexName).build());
//        System.out.println(deleteIndexResponse);
//    }
    @GetMapping("/getAllMovies")
    List<Movie> getAllMovies() throws Exception {
        return ConvertorFromSearchResponseToList.convert(movieESService.getAllMovies());
    }

    @PutMapping("/addMoviesInBulk")
    BulkResponse addMoviesInBulk(List<Movie> movies) throws Exception {
        return movieESService.insertMoviesInBulk(movies);
    }
}
