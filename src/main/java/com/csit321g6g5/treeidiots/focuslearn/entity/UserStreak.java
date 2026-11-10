package com.csit321g6g5.treeidiots.focuslearn.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_streak")
public class UserStreak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "streak_id")
    private Long streakId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "current_streak")
    private Integer currentStreak;

    @Column(name = "longest_streak")
    private Integer longestStreak;

    @Column(name = "last_goal_met_date")
    private LocalDate lastGoalMetDate;

    public UserStreak() {}

    public Long getStreakId() { return streakId; }
    public void setStreakId(Long streakId) { this.streakId = streakId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Integer getCurrentStreak() { return currentStreak; }
    public void setCurrentStreak(Integer currentStreak) { this.currentStreak = currentStreak; }
    public Integer getLongestStreak() { return longestStreak; }
    public void setLongestStreak(Integer longestStreak) { this.longestStreak = longestStreak; }
    public LocalDate getLastGoalMetDate() { return lastGoalMetDate; }
    public void setLastGoalMetDate(LocalDate lastGoalMetDate) { this.lastGoalMetDate = lastGoalMetDate; }
}