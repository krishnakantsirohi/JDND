package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.NotFoundException;
import com.udacity.course3.reviews.model.Comments;
import com.udacity.course3.reviews.model.Reviews;
import com.udacity.course3.reviews.repository.CommentsRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // TODO: Wire needed JPA repositories here
    private final CommentsRepository commentsRepository;
    private final ReviewsRepository reviewsRepository;

    public CommentsController(CommentsRepository commentsRepository, ReviewsRepository reviewsRepository){
        this.commentsRepository = commentsRepository;
        this.reviewsRepository = reviewsRepository;
    }

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") String reviewId, @RequestBody Comments comment) throws NotFoundException {
        Optional<Reviews> optionalReview = reviewsRepository.findById(reviewId);
        if (!optionalReview.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        comment = commentsRepository.save(comment);
        Reviews reviews = optionalReview.get();
        reviews.getComments().add(comment);
        reviewsRepository.save(reviews);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listCommentsForReview(@PathVariable("reviewId") String reviewId) throws NotFoundException {
        Optional<Reviews> reviews = reviewsRepository.findById(reviewId);
        if (!reviews.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reviews.get().getComments(), HttpStatus.OK);
    }
}