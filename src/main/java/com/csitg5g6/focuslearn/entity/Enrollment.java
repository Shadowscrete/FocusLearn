package com.csitg5g6.focuslearn.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="enrollments",uniqueConstraints=@UniqueConstraint(columnNames={"userID","courseID"}))
public class Enrollment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer enrollmentID;
 @ManyToOne @JoinColumn(name="userID",nullable=false) private User user;
 @ManyToOne @JoinColumn(name="courseID",nullable=false) private Course course;
 private LocalDateTime dateEnrolled=LocalDateTime.now();
 public Integer getEnrollmentID(){return enrollmentID;} public void setEnrollmentID(Integer v){enrollmentID=v;}
 public User getUser(){return user;} public void setUser(User v){user=v;}
 public Course getCourse(){return course;} public void setCourse(Course v){course=v;}
 public LocalDateTime getDateEnrolled(){return dateEnrolled;} public void setDateEnrolled(LocalDateTime v){dateEnrolled=v;}
}
