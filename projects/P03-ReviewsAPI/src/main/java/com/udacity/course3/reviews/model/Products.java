package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private Double cost;
    @CreatedDate
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false, nullable = false)
    private Date createddatetime;

    @OneToMany(mappedBy = "products", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Reviews> reviews;

    public Products(){}

    public Products(Integer id, @NotNull String name, @NotNull Double cost, Date createddatetime) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
