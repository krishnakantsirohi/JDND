package com.udacity.course3.reviews.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Document("products")
public class Products {
    @Id
    private String id;

    @NotNull
    private String name;
    @NotNull
    private Double cost;
    private Date createddatetime;

    @DBRef
    private List<Reviews> reviews = new ArrayList<>();

    public Products(){}

    public Products(String id, @NotNull String name, @NotNull Double cost, Date createddatetime) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.createddatetime = createddatetime;
    }

    public Products(@NotNull String name, @NotNull Double cost, Date createddatetime) {
        this.name = name;
        this.cost = cost;
        this.createddatetime = createddatetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString(){
        return this.id + "-" + this.name + "-" + this.cost + "-" + this.createddatetime + "-" + this.reviews;
    }
}
