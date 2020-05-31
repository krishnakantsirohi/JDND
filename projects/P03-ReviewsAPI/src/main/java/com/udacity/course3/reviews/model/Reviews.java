package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String subject;
    @NotNull
    private String review_text;
    @CreatedDate
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false, nullable = false)
    private Date createddatetime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Products products;

    @OneToMany(mappedBy = "reviews", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Comments> comments;

    public Reviews() {
    }

    public Reviews(Integer id, @NotNull String subject, @NotNull String review_text, Date createddatetime) {
        this.id = id;
        this.subject = subject;
        this.review_text = review_text;
        this.createddatetime = createddatetime;
    }

    public Reviews(@NotNull String subject, @NotNull String review_text, Date createddatetime) {
        this.subject = subject;
        this.review_text = review_text;
        this.createddatetime = createddatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString(){
        return this.id + "-" + this.subject + "-" + this.review_text + "-" + this.createddatetime + "-" + this.comments;
    }
}
