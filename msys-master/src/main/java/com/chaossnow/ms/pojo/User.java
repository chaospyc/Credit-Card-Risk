package com.chaossnow.ms.pojo;


import javax.validation.constraints.NotBlank;

public class User {

  private long id;
  @NotBlank
  private String username;
  private String password;
  private String salt;
  private String name;
  private String phone;
  private String email;
  private boolean enabled;


  public User() {
  }

  public User(long id,
              String username,
              String password,
              String salt,
              String name,
              String phone,
              String email,
              boolean enabled) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.salt = salt;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.enabled = enabled;
  }


  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", enabled=" + enabled +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


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


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
