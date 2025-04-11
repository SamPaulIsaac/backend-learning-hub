package com.sam.mongoDB.service;

import com.sam.mongoDB.entity.Comment;
import com.sam.mongoDB.entity.Post;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Post createPost(Post post);

    List<Post> getAllPosts();

    Optional<Post> getPostById(String id);

    void deletePost(String id);

    Comment addComment(String postId, Comment comment);

    List<Comment> getCommentsByPostId(String postId);

    void deleteComment(String commentId);

    Post updatePost(String id, Post updatedPost);
}
