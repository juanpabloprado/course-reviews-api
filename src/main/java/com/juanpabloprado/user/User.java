package com.juanpabloprado.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juanpabloprado.core.BaseEntity;
import javax.persistence.Entity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class User extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  private String firstName;
  private String lastName;
  private String username;
  @JsonIgnore
  private String password;
}
