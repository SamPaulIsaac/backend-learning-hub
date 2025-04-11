package com.sam.mongoDB.service;

import com.sam.mongoDB.entity.Comment;
import com.sam.mongoDB.entity.Post;
import com.sam.mongoDB.repository.CommentRepository;
import com.sam.mongoDB.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    // CRUD operations for posts
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(String id) {
        return postRepository.findById(id);
    }

    public Post updatePost(String id, Post updatedPost) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        return postRepository.save(existingPost);
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

    // CRUD operations for comments
    public Comment addComment(String postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        if (null != post.getComments()) {
            post.getComments().add(comment);
        } else {
            post.setComments(Collections.singletonList(comment));
        }
        postRepository.save(post);
        return comment;
    }

    public List<Comment> getCommentsByPostId(String postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return post.getComments();
    }

    public void deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
    }
}
