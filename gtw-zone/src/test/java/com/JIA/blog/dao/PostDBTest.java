package com.JIA.blog.dao;

import com.JIA.blog.TestApplicationConfiguration;
import com.JIA.blog.dto.Post;
import com.JIA.blog.dto.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class PostDBTest {

    @Autowired
    PostDao postDao;

    @Test
    void addPost() {

      Post post = new Post( 1, "Hello", "Hello World", "#Greeting", false);
      postDao.addPost(post);

      Post expectedPost = postDao.getPostById(post.getPostId());

      assertTrue(post.equals(expectedPost));
    }

    @Test
    void getPostById() {

      Post post = new Post( 1, "Hello", "Hello World", "#Greeting", false);
      post.setPostId(1);

      Post expectedPost = postDao.getPostById(post.getPostId());

      assertTrue(post.equals(expectedPost));
    }
}
