package com.csit321g6g5.treeidiots.focuslearn.controller;

import com.csit321g6g5.treeidiots.focuslearn.entity.ContentPage;
import com.csit321g6g5.treeidiots.focuslearn.service.ContentPageService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/content-pages")
@CrossOrigin(origins = "*")
public class ContentPageController {
    private final ContentPageService service;

    public ContentPageController(ContentPageService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContentPage> getAll() { return service.getAll(); }

    @PostMapping
    public ContentPage create(@RequestBody ContentPage page) { return service.save(page); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}