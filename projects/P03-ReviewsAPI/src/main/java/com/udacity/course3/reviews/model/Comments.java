package com.udacity.course3.reviews.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Document("comments")
public class Comments {
    @Id
    private String id;
    @NotNull
    private String comment_text;
    private Date createddatetime;

    public Comments() {
    }

    public Comments(String id, @NotNull String comment_text, Date createddatetime) {
        this.id = id;
        this.comment_text = comment_text;
        this.createddatetime = createddatetime;
    }

    public Comments(@NotNull String comment_text, Date createddatetime) {
        this.comment_text = comment_text;
        this.createddatetime = createddatetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    @Override
    public String toString(){
        return this.id + "-" + this.comment_text + "-" + this.createddatetime;
    }
}
