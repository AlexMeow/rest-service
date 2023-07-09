package com.example.restservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    public Long getCommentId() {
        return commentId;
    }

    public Long getPostId() {
        return this.postId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getContent() {
        return this.content;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }
}