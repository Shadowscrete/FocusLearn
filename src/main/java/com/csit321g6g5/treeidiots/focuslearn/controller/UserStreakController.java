package com.csit321g6g5.treeidiots.focuslearn.controller;

import com.csit321g6g5.treeidiots.focuslearn.entity.UserStreak;
import com.csit321g6g5.treeidiots.focuslearn.service.UserStreakService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-streaks")
@CrossOrigin(origins = "*")
public class UserStreakController {

    private final UserStreakService userStreakService;

    public UserStreakController(UserStreakService userStreakService) {
        this.userStreakService = userStreakService;
    }

    @GetMapping
    public List<UserStreak> getAllStreaks() {
        return userStreakService.getAllStreaks();
    }

    @PostMapping
    public UserStreak createStreak(@RequestBody UserStreak streak) {
        return userStreakService.createStreak(streak);
    }

    @DeleteMapping("/{id}")
    public void deleteStreak(@PathVariable Long id) {
        userStreakService.deleteStreak(id);
    }
}