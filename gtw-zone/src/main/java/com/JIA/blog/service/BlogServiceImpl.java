/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.service;

import com.JIA.blog.dto.Post;
import com.JIA.blog.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fishget
 */
@Service
@ComponentScan("Service")
public class BlogServiceImpl {

    @Autowired
    com.JIA.blog.dao.PostDao PostDao;

    @Autowired
    com.JIA.blog.dao.UserDao UserDao;

    public List<Post> getAllPosts() {
        List<Post> posts = PostDao.getAllPosts();
        return posts;
    }

    public List<Post> getAllPublicPosts() {
        List<Post> posts = PostDao.getAllPosts();
        List<Post> publicPosts= new ArrayList<Post>();
        for (Post post: posts){
            if (post.isIsPrivate()== false){
                publicPosts.add(post);
            }
        }
        return publicPosts;
    }

    public List<User> getAllUsers() {
        List<User> users = UserDao.getAllUsers();
        return users;
    }
    public User getUserById(int userId) {
        User user = UserDao.getUserById(userId);
        return user;
    }
    public Post getPostById(int postId) {
        Post post = PostDao.getPostById(postId);
        return post;
    }
    public List <Post> getPostByUserId(int userId) {
        List<Post> posts = PostDao.getPostByUserId(userId);
        return posts;
    }

    public Post addPost(int userId, String subject, String content, String tag, boolean isPrivate){
        Post post = new Post();
        post.setUserId(userId);
        post.setSubject(subject);
        post.setContent(content);
        post.setTag(tag);
        post.setIsPrivate(isPrivate);
        PostDao.addPost(post);
        return post;
    }

    public Post updatePost(int postId, int userId, String subject, String content, String tag, boolean isPrivate){
        Post post = PostDao.getPostById(postId);
        post.setPostId(postId);
        post.setUserId(userId);
        post.setSubject(subject);
        post.setContent(content);
        post.setTag(tag);
        post.setIsPrivate(isPrivate);
        PostDao.updatePost(post);
        return post;
    }

    public User addUser(String username, String password, String firstName, String lastName, String role){
        User user= new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        UserDao.addUser(user);
        return user;

    }

    public User udateUser( int userId, String username, String password, String firstName, String lastName, String role){
        User user= UserDao.getUserById(userId);
        user.setUserId(userId);
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        UserDao.updateUser(user);
        return user;

    }

    public void deletePost(int postId){
      PostDao.deletePost(postId);
    }




}
