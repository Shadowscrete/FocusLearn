package com.csit321g6g5.treeidiots.focuslearn.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer userID;
 @Column(nullable=false, unique=true) private String username;
 @Column(nullable=false, unique=true) private String email;
 @Column(nullable=false) private String passwordHash;
 @Column(nullable=false) private String role;
 private LocalDateTime createdAt=LocalDateTime.now();
 @JsonIgnore @OneToOne(mappedBy="user", cascade=CascadeType.ALL) private AccessibilityProfile accessibilityProfile;
 public Integer getUserID(){return userID;} public void setUserID(Integer v){userID=v;}
 public String getUsername(){return username;} public void setUsername(String v){username=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
