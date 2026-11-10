package com.csit321g6g5.treeidiots.focuslearn.controller;
import com.csit321g6g5.treeidiots.focuslearn.entity.Enrollment;
import com.csit321g6g5.treeidiots.focuslearn.repository.EnrollmentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin
public class EnrollmentController {

  private final EnrollmentRepository repository;
  public EnrollmentController(EnrollmentRepository repository) { 
    this.repository=repository; 
  }
  @GetMapping public List<Enrollment> getAll() { 
    return repository.findAll(); 
  }
  @GetMapping("/{id}") 
  public ResponseEntity<Enrollment> getById(@PathVariable Integer id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
  @PostMapping public Enrollment create(@RequestBody Enrollment item) { item.setEnrollmentID(null); return repository.save(item); }
  @PutMapping("/{id}") public ResponseEntity<Enrollment> update(@PathVariable Integer id,@RequestBody Enrollment item) {
    if(!repository.existsById(id)) return ResponseEntity.notFound().build();
    item.setEnrollmentID(id);
    return ResponseEntity.ok(repository.save(item));
  }
  @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Integer id) {
    if(!repository.existsById(id)) return ResponseEntity.notFound().build();
    repository.deleteById(id); return ResponseEntity.noContent().build();
  }
}
