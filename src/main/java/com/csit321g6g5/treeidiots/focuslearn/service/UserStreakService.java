package com.csit321g6g5.treeidiots.focuslearn.service;

import com.csit321g6g5.treeidiots.focuslearn.entity.UserStreak;
import com.csit321g6g5.treeidiots.focuslearn.repository.UserStreakRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserStreakService {

    private final UserStreakRepository userStreakRepository;

    public UserStreakService(UserStreakRepository userStreakRepository) {
        this.userStreakRepository = userStreakRepository;
    }

    public List<UserStreak> getAllStreaks() {
        return userStreakRepository.findAll();
    }

    public Optional<UserStreak> getStreakById(Long id) {
        return userStreakRepository.findById(id);
    }

    public UserStreak createStreak(UserStreak streak) {
        return userStreakRepository.save(streak);
    }

    public void deleteStreak(Long id) {
        userStreakRepository.deleteById(id);
    }
}