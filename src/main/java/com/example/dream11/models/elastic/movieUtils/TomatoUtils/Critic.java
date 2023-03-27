package com.example.dream11.models.elastic.movieUtils.TomatoUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Critic {
    private String rating;
    private Integer numReviews;
    private Integer meter;
}
