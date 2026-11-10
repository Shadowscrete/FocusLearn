package com.csit321g6g5.treeidiots.focuslearn.repository;
import com.csit321g6g5.treeidiots.focuslearn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
