package com.JIA.blog.dao;

import com.JIA.blog.TestApplicationConfiguration;
import com.JIA.blog.dto.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class UserDBTest {
  @Autowired
  UserDao userDao;

    @org.junit.jupiter.api.Test
    void addUser() {
      User user = new User("test","0000","test","test","test");
      userDao.addUser(user);

      User expectedUser = userDao.getUserById(user.getUserId());

      assertTrue(user.equals(expectedUser));


    }

    @org.junit.jupiter.api.Test
    void getUserById() {

      User user = new User("Andong", "Admin", "An", "Dong", "Admin");
      user.setUserId(1);

      User expectedUser = userDao.getUserById(user.getUserId());

      assertTrue(user.equals(expectedUser));
    }
}
