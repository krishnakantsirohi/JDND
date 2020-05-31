package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Products;
import com.udacity.course3.reviews.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findAllByProducts_Id(Integer id);
}
