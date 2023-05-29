package com.moose.movies.service;

import com.moose.movies.entity.Movie;
import com.moose.movies.entity.Review;
import com.moose.movies.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MongoTemplate mongoTemplate){
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(String reviewBody, String imdbNo){
        Review review = reviewRepository.insert(new Review(reviewBody));

         mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbNo))
                 .apply(new Update().push("reviewIds").value(review))
                 .first();

         return review;
    }

}
