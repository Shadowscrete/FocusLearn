package com.csitg5g6.focuslearn.repository;
import com.csitg5g6.focuslearn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {}
