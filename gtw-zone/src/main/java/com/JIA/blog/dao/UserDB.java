/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JIA.blog.dao;

import com.JIA.blog.dto.User;
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

public class UserDB implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    public static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setRole(rs.getString("role"));
            return user;
        }
    }

    public User addUser(User user) {
        final String INSERT_USER = "INSERT INTO user(user_name, password, first_name, last_name,role) VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_USER, user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),user.getRole());
        int newUserId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserId(newUserId);
        return getUserById(newUserId);
    }

       public List<User> getAllUsers() {
        final String SELECT_ALL_USERS = "SELECT * FROM user";
        return jdbc.query(SELECT_ALL_USERS, new UserMapper());
    }


    public User getUserById(int userId) {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE user_id = ?";
            return jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), userId);

    }

     public void updateUser(User user) {
        final String UPDATE_USER = "UPDATE user SET user_name = ?, password = ?, first_name = ?, last_name = ?, role = ? WHERE user_id = ?";
        jdbc.update(UPDATE_USER, user.getUserName(), user.getPassword(),user.getFirstName(),user.getLastName(),user.getRole(),user.getUserId());
    }

}
