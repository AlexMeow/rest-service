package com.example.restservice.controller;

import com.example.restservice.dto.PostDto;
import com.example.restservice.model.Post;
import com.example.restservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);

            // Transfer Post entity to PostDto
            PostDto postDto = new PostDto();
            postDto.setPostId(post.getPostId());
            postDto.setUserId(post.getUserId());
            postDto.setContent(post.getContent());
            postDto.setImgUrl(post.getImgUrl());
            postDto.setTimestamp(post.getTimestamp());

            return ResponseEntity.ok(postDto);
    }

    // TEST
//    @GetMapping("/test")
//    public ResponseEntity<PostDto> test(@RequestParam(value = "postId", defaultValue = "1") Long postId) {
//        return getPostById(postId);
//    }
}
