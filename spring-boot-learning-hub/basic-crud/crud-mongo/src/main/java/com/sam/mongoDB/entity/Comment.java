package com.sam.mongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "posts")
public class Comment {
    @Id
    private String id;
    private String content;
    private String author;
}
