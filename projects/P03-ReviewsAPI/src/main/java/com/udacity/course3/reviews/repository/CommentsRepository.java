package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Comments;
import com.udacity.course3.reviews.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findAllByReviews(Reviews review);
}
