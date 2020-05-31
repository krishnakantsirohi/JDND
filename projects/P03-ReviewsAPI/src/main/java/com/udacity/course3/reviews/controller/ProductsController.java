package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.NotFoundException;
import com.udacity.course3.reviews.model.Products;
import com.udacity.course3.reviews.repository.ProductsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    // TODO: Wire JPA repositories here
    private final ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody Products products) {
        productsRepository.save(products);
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws NotFoundException {
        Optional<Products> optionalProducts = productsRepository.findById(id);
        if (!optionalProducts.isPresent())
            throw new NotFoundException("Product " + id + " Not Found.");
        Products product = optionalProducts.get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listProducts() {
        List<Products> products = productsRepository.findAll();
        return products.size()>0?new ResponseEntity<>(products, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}