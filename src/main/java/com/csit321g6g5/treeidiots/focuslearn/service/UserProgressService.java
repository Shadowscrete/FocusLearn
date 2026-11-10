package com.csit321g6g5.treeidiots.focuslearn.service;

import com.csit321g6g5.treeidiots.focuslearn.entity.UserProgress;
import com.csit321g6g5.treeidiots.focuslearn.repository.UserProgressRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProgressService {
    private final UserProgressRepository repository;

    public UserProgressService(UserProgressRepository repository) {
        this.repository = repository;
    }

    public List<UserProgress> getAll() { return repository.findAll(); }
    
    public UserProgress save(UserProgress progress) {
        if (progress.getLastAccessed() == null) {
            progress.setLastAccessed(java.time.LocalDateTime.now());
        }
        return repository.save(progress);
    }
    
    public void delete(Long id) { repository.deleteById(id); }
}