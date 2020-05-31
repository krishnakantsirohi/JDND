package com.udacity.course3.reviews.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class Reviews {

    @Id
    private String id;
    @NotNull
    private String subject;
    @NotNull
    private String review_text;
    private Date createddatetime;
    private List<Comments> comments = new ArrayList<>();

    public Reviews() {
    }

    public Reviews(String id, @NotNull String subject, @NotNull String review_text, Date createddatetime) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString(){
        return this.id + "-" + this.subject + "-" + this.review_text + "-" + this.comments + "-" + this.createddatetime;
    }
}
