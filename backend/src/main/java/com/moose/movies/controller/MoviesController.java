package com.moose.movies.controller;

import com.moose.movies.entity.Movie;
import com.moose.movies.service.MoviesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    private final MoviesService moviesService;
    @Autowired
    public MoviesController(MoviesService moviesService){
        this.moviesService = moviesService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(moviesService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbNo}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbNo){

        return new ResponseEntity<Optional<Movie>>(moviesService.singleMovie(imdbNo), HttpStatus.OK);
    }
}
