package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewsRepository extends MongoRepository<Reviews, String> {
    Optional<Reviews> findById(String id);
}
