package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {
    Optional<Products> findById(String id);
}
