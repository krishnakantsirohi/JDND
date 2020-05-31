package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommentsRepository extends MongoRepository<Comments, String> {
    Optional<Comments> findById(String review_id);
}
