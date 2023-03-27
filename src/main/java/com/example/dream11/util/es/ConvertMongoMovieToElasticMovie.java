package com.example.dream11.util.es;

import com.example.dream11.models.elastic.Movie;
import com.example.dream11.models.mongo.MongoMovie;

public class ConvertMongoMovieToElasticMovie {
    public static Movie convertMongoMovieToElasticMovie(MongoMovie mongoMovie) {
        Movie movie = new Movie();
        movie.setTitle(mongoMovie.getTitle());
        movie.setCast(mongoMovie.getCast());
        movie.setAwards(mongoMovie.getAwards());
        movie.setFullPlot(mongoMovie.getFullplot());
        movie.setDirectors(mongoMovie.getDirectors());
        movie.setCountries(mongoMovie.getCountries());
        movie.setImdb(mongoMovie.getImdb());
        movie.setGenres(mongoMovie.getGenres());
        movie.setPlot(mongoMovie.getPlot());
        movie.setLastUpdated(mongoMovie.getLastUpdated());
        movie.setNum_mflix_comments(mongoMovie.getNum_mflix_comments());
        movie.setReleased(mongoMovie.getReleased());
        movie.setType(mongoMovie.getType());
        movie.setTomatoes(mongoMovie.getTomatoes());
        movie.setRated(mongoMovie.getRated());
        movie.setYear(mongoMovie.getYear());
        return movie;
    }
}
