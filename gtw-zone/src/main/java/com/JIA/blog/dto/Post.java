/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.dto;

import java.util.Objects;

/**
 *
 * @author Fishget
 */
public class Post {
    private int postId;
    private int userId;
    private String subject;
    private String content;
    private String tag;
    private boolean isPrivate;

    public Post() {
    }


    public Post(int userId,String subject, String content, String tag, boolean isPrivate) {
        this.userId = userId;
        this.subject = subject;
        this.content = content;
        this.tag = tag;
        this.isPrivate = isPrivate;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Post post = (Post) o;
    return postId == post.postId &&
      userId == post.userId &&
      isPrivate == post.isPrivate &&
      Objects.equals(subject, post.subject) &&
      Objects.equals(content, post.content) &&
      Objects.equals(tag, post.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(postId, userId, subject, content, tag, isPrivate);
  }

  public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }


}
