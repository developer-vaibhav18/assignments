package com.example.dream11.models.elastic;

import com.example.dream11.models.elastic.movieUtils.Awards;
import com.example.dream11.models.elastic.movieUtils.Imdb;
import com.example.dream11.models.elastic.movieUtils.Tomatoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String _id;
    private String plot;
    private List<String> genres;
    private Integer runtime;
    private List<String> cast;
    private Integer num_mflix_comments;
    private String title;
    private String fullPlot;
    private List<String> countries;
    private Date released;
    private List<String> directors;
    private String rated;
    private Awards awards;
    private Date lastUpdated;
    private Integer year;
    private Imdb imdb;
    private String type;
    private Tomatoes tomatoes;
}
