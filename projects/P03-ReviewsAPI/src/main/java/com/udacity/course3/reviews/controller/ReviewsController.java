package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.NotFoundException;
import com.udacity.course3.reviews.model.Products;
import com.udacity.course3.reviews.model.Reviews;
import com.udacity.course3.reviews.repository.ProductsRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    private final ReviewsRepository reviewsRepository;
    private final ProductsRepository productsRepository;

    public ReviewsController(ReviewsRepository reviewsRepository, ProductsRepository productsRepository){
        this.reviewsRepository = reviewsRepository;
        this.productsRepository = productsRepository;
    }

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") String productId, @Valid @RequestBody Reviews reviews) throws NotFoundException {
        Optional<Products> optionalProducts = productsRepository.findById(productId);
        if (!optionalProducts.isPresent())
            throw new NotFoundException("Product " + productId + " Not Found.");
        reviews = reviewsRepository.save(reviews);
        Products products = optionalProducts.get();
        products.getReviews().add(reviews);
        productsRepository.save(products);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") String productId) {
        Optional<Products> product = productsRepository.findById(productId);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<?> reviews = product.get().getReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}