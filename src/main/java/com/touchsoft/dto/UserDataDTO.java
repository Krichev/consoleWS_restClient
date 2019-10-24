package com.touchsoft.dto;

import com.touchsoft.model.Role;

import java.io.Serializable;
import java.util.List;

public class UserDataDTO implements Serializable {
  
  private String username;
  private String password;

  public UserDataDTO() {
  }

  public UserDataDTO(String username, String password, List<Role> roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  List<Role> roles;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

}
