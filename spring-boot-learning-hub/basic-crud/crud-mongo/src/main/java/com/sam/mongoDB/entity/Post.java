package com.sam.mongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private List<Comment> comments;
}

