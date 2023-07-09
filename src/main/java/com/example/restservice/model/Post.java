package com.example.restservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "created_at")
    private Date createdAt;

    public Long getPostId() {
        return this.postId;
    }
    public Long getUserId() {
        return this.userId;
    }

    public String getContent() {
        return this.content;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public Date getTimestamp() {
        return this.createdAt;
    }
}