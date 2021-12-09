/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.dao;
import com.JIA.blog.dto.Post;

import java.util.List;

/**
 *
 * @author Fishget
 */
public interface PostDao {
    Post addPost(Post post) ;
    List<Post> getAllPosts();
    Post getPostById(int postId);
    List<Post> getPostByUserId(int userId);
    void updatePost(Post post);
}
