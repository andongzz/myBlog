/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.dao;


import com.JIA.blog.dto.User;

import java.util.List;

/**
 *
 * @author Fishget
 */
public interface UserDao {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(int userId);
    void updateUser(User user);
}
