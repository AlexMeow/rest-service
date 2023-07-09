package com.example.restservice.dto;

import java.util.Date;

public class PostDto {
    private Long postId;
    private Long userId;
    private String content;
    private String imgUrl;
    private Date createdAt;

    // Default constructor
    public PostDto() {

    }

    // Constructor
    public PostDto(Long postId, Long userId, String content, String imgUrl, Date createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createdAt = createdAt;
    }

    // Getter and setter
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
