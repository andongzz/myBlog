/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.App;

import com.JIA.blog.dto.Post;
import com.JIA.blog.dto.User;
import com.JIA.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.Session;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Fishget
 */
@RestController
@RequestMapping("/blog")
@ComponentScan("com")
public class Controller {
    @Autowired
    BlogServiceImpl service;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/allposts")
    public ModelAndView getAllPosts(Map map) {
        List<Post> allPosts = service.getAllPosts();
        map.put("posts", allPosts);
        return new ModelAndView("user-blog.html");
    }

    @GetMapping("/publicposts")
    public ModelAndView getAllPublicPosts(Map map) {
        List<Post> allPublicPosts = service.getAllPublicPosts();
        map.put("posts", allPublicPosts);
        return new ModelAndView("user-blog.html");
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return service.getUserById(userId);
    }

    @GetMapping("/postlist/{userId}")
    public List<Post> getPostByUserId(@PathVariable("userId") int userId) {
        return service.getPostByUserId(userId);
    }

    @GetMapping("/post/{postId}")
    public ModelAndView getPostById(@PathVariable("postId") int postId, Map map) {
      Post post = service.getPostById(postId);
      map.put("post", post);
        return new ModelAndView("user-blog-detail.html");
    }

    @PostMapping("/adduser")
    public User addUser(String username, String password, String firstName, String lastName, String role) {
        return service.addUser(username, password, firstName, lastName, role);
    }

    @PostMapping("/addpost")
    public RedirectView addPost(@RequestParam("blogTitle") String subject,
                                @RequestParam("blogContent") String content,
                                @RequestParam("blogTag") String tag) {
        int userId = 1;
        service.addPost(userId, subject, content, tag, false);
        return new RedirectView("/blog/allposts");
    }

    @PostMapping("/editpost/{postId}")
    public RedirectView editPost(@RequestParam("blogTitle") String subject,
                         @RequestParam("blogContent") String content,
                         @RequestParam("blogTag") String tag,
                         @PathVariable("postId") int blogId) {

      service.updatePost(blogId,1, subject, content, tag, false);

      return new RedirectView("/blog/allposts");
    }

    @PostMapping("/edituser")
    public User editUser(int userId, String username, String password, String firstName, String lastName, String role) {
        return service.udateUser(userId, username, password, firstName, lastName, role);
    }

    @GetMapping("/newpost")
    public ModelAndView newPost() {
        return new ModelAndView("blog-create");
    }

  @GetMapping("/deletePost/{postId}")
  public RedirectView deletePost(@PathVariable("postId") int blogId) {
      service.deletePost(blogId);
    return new RedirectView("/blog/allposts");
  }

}
