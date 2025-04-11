package com.sam.mongoDB.controller;

import com.sam.mongoDB.entity.Comment;
import com.sam.mongoDB.entity.Post;
import com.sam.mongoDB.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
@AllArgsConstructor
public class BlogController {
    private BlogService blogService;

    // CRUD operations for posts
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return blogService.createPost(post);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return blogService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable String id) {
        return blogService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post updatedPost) {
        return blogService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable String id) {
        blogService.deletePost(id);
    }

    // CRUD operations for comments
    @PostMapping("/posts/{postId}/comments")
    public Comment addComment(@PathVariable String postId, @RequestBody Comment comment) {
        return blogService.addComment(postId, comment);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable String postId) {
        return blogService.getCommentsByPostId(postId);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        blogService.deleteComment(commentId);
    }
}
