package com.moose.movies.service;

import com.moose.movies.entity.Movie;
import com.moose.movies.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private MoviesRepository moviesRepository;
    @Autowired
    public MoviesService(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    public List<Movie> allMovies(){
        return moviesRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbNo){
        return moviesRepository.findMovieByImdbId(imdbNo);
    }
}
