package com.csit321g6g5.treeidiots.focuslearn.service;

import com.csit321g6g5.treeidiots.focuslearn.entity.ContentPage;
import com.csit321g6g5.treeidiots.focuslearn.repository.ContentPageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContentPageService {
    private final ContentPageRepository repository;

    public ContentPageService(ContentPageRepository repository) {
        this.repository = repository;
    }

    public List<ContentPage> getAll() { return repository.findAll(); }
    public ContentPage save(ContentPage page) { return repository.save(page); }
    public void delete(Long id) { repository.deleteById(id); }
}