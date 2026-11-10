package com.csit321g6g5.treeidiots.focuslearn.controller;

import com.csit321g6g5.treeidiots.focuslearn.entity.UserProgress;
import com.csit321g6g5.treeidiots.focuslearn.service.UserProgressService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-progress")
@CrossOrigin(origins = "*")
public class UserProgressController {
    private final UserProgressService service;

    public UserProgressController(UserProgressService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserProgress> getAll() { return service.getAll(); }

    @PostMapping
    public UserProgress create(@RequestBody UserProgress progress) { return service.save(progress); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}