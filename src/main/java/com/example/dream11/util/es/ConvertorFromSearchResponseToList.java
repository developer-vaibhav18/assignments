package com.example.dream11.util.es;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.dream11.models.elastic.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConvertorFromSearchResponseToList {
    public static <T> List<T> convert(SearchResponse<T> searchResponse) {
        List<T> list = new ArrayList<>();
        for(Hit h : searchResponse.hits().hits()) {
            list.add((T)h.source());
        }
        return list;
    }
}
