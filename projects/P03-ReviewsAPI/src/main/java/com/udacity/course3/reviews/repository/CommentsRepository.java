package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Comments;
import com.udacity.course3.reviews.model.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentsRepository extends MongoRepository<Comments, Integer> {
    List<Comments> findAllByReviews(Reviews review);
}
