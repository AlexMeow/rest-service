package com.example.restservice.controller;

import com.example.restservice.dto.CommentDto;
import com.example.restservice.model.Comment;
import com.example.restservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);

            // Transfer Comment entity to CommentDto
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentId(comment.getCommentId());
            commentDto.setUserId(comment.getUserId());
            commentDto.setContent(comment.getContent());
            commentDto.setCreatedAt(comment.getCreatedAt());

            return ResponseEntity.ok(commentDto);
    }

    // TEST
//    @GetMapping("/test")
//    public ResponseEntity<CommentDto> test(@RequestParam(value = "commentId", defaultValue = "1") Long commentId) {
//        return getCommentById(commentId);
//    }
}
