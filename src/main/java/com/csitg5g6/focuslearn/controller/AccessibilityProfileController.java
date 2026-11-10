package com.csitg5g6.focuslearn.controller;
import com.csitg5g6.focuslearn.entity.AccessibilityProfile;
import com.csitg5g6.focuslearn.repository.AccessibilityProfileRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/accessibility-profiles")
@CrossOrigin
public class AccessibilityProfileController {
  private final AccessibilityProfileRepository repository;
  public AccessibilityProfileController(AccessibilityProfileRepository repository) { 
    this.repository=repository; 
  }
  @GetMapping public List<AccessibilityProfile> getAll() { 
    return repository.findAll(); 
  }
  @GetMapping("/{id}") 
  public ResponseEntity<AccessibilityProfile> getById(@PathVariable Integer id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping public AccessibilityProfile create(@RequestBody AccessibilityProfile item) {
     item.setProfileID(null); return repository.save(item); 
    }
  @PutMapping("/{id}") public ResponseEntity<AccessibilityProfile> update(@PathVariable Integer id,@RequestBody AccessibilityProfile item) {
    
    if(!repository.existsById(id)) return ResponseEntity.notFound().build();
    item.setProfileID(id);

    return ResponseEntity.ok(repository.save(item));
  }
  
  @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Integer id) {
    if(!repository.existsById(id)) return ResponseEntity.notFound().build();
    repository.deleteById(id); return ResponseEntity.noContent().build();
  }
}
