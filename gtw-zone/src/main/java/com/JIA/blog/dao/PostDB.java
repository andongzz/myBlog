/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.dao;

import com.JIA.blog.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fishget
 */

@Repository
public class PostDB implements PostDao{

    @Autowired
    JdbcTemplate jdbc;

    public static final class PostMapper implements RowMapper<Post> {
        public Post mapRow(ResultSet rs, int index) throws SQLException {
            Post post = new Post();
            post.setPostId(rs.getInt("post_id"));
            post.setUserId(rs.getInt("user_id"));
            post.setSubject(rs.getString("subject"));
            post.setContent(rs.getString("content"));
            post.setTag(rs.getString("tag"));
            post.setIsPrivate(rs.getBoolean("isPrivate"));
            return post;
        }
    }

    public Post addPost(Post post) {
        final String INSERT_POST = "INSERT INTO post(user_id, subject, content, tag, isPrivate) VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_POST,post.getUserId(),post.getSubject(),post.getContent(),post.getTag(),post.isIsPrivate());
        int newPostId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setPostId(newPostId);
        return getPostById(newPostId);
    }

    public List<Post> getAllPosts() {
        final String SELECT_ALL_POSTS = "SELECT * FROM post ORDER BY post_id DESC";
        return jdbc.query(SELECT_ALL_POSTS, new PostMapper());
    }

    public Post getPostById(int postId) {
        final String SELECT_POST_BY_ID = "SELECT * FROM post WHERE post_id = ?";
        return jdbc.queryForObject(SELECT_POST_BY_ID, new PostMapper(), postId);
    }
    public List<Post> getPostByUserId(int userId) {
        final String SELECT_ALL_POSTS = "SELECT * FROM post WHERE user_id = ?";
        return jdbc.query(SELECT_ALL_POSTS, new PostMapper(), userId);
    }

     public void updatePost(Post post) {
        final String UPDATE_POST = "UPDATE post SET user_id = ?, subject = ?, content = ?, tag = ?, isPrivate = ? WHERE post_id = ?";
        jdbc.update(UPDATE_POST, post.getUserId(),post.getSubject(),post.getContent(),post.getTag(),post.isIsPrivate(),post.getPostId());
    }

  public void deletePost(int postId) {
    final String DELETE_POST = "DELETE from post WHERE post_id = ?";
    jdbc.update(DELETE_POST, postId);
  }

}
