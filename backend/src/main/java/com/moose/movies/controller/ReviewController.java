package com.moose.movies.controller;


import com.moose.movies.entity.Review;
import com.moose.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/reviews")
public class ReviewController {


    private final ReviewService reviewService;
    @Autowired
    public ReviewController (ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){

        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
