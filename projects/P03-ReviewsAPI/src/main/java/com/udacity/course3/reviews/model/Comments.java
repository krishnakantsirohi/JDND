package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String comment_text;
    @CreatedDate
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false, nullable = false)
    private Date createddatetime;

    @ManyToOne
    @JoinColumn(name = "reviews_id", referencedColumnName = "id")
    @JsonBackReference
    private Reviews reviews;

    public Comments() {
    }

    public Comments(Integer id, @NotNull String comment_text, Date createddatetime) {
        this.id = id;
        this.comment_text = comment_text;
        this.createddatetime = createddatetime;
    }

    public Comments(@NotNull String comment_text, Date createddatetime) {
        this.comment_text = comment_text;
        this.createddatetime = createddatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString(){
        return this.id + "-" + this.comment_text + "-" + this.createddatetime;
    }
}
