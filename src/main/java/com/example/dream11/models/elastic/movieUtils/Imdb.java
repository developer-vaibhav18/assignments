package com.example.dream11.models.elastic.movieUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imdb {
    private Float ratings;
    private Integer votes;
    private Integer id;
}
