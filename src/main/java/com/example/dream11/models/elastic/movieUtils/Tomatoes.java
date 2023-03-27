package com.example.dream11.models.elastic.movieUtils;

import com.example.dream11.models.elastic.movieUtils.TomatoUtils.Critic;
import com.example.dream11.models.elastic.movieUtils.TomatoUtils.Viewer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Tomatoes {
    private Viewer viewer;
    private Critic critic;
    private Integer fresh;
    private Integer rotten;
}
