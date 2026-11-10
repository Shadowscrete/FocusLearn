package com.csit321g6g5.treeidiots.focuslearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "FocusLearn API is running. Available routes: /api/users, /api/enrollments, /api/accessibility-profiles.";
    }
}
