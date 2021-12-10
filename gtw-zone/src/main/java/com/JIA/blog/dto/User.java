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
public class User {
    private int userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + '}';
    }

    public void setRole(String role) {
        this.role = role;
    }


    public User() {
    }

    public User(String userName, String password, String firstName, String lastName,String role) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return userId == user.userId &&
      Objects.equals(userName, user.userName) &&
      Objects.equals(password, user.password) &&
      Objects.equals(firstName, user.firstName) &&
      Objects.equals(lastName, user.lastName) &&
      Objects.equals(role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, userName, password, firstName, lastName, role);
  }
}
