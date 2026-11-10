package com.csitg5g6.focuslearn.controller;
import com.csitg5g6.focuslearn.entity.User;
import com.csitg5g6.focuslearn.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
  private final UserRepository repository;
  public UserController(UserRepository repository) { 
    this.repository=repository; 
  }
  @GetMapping public List<User> getAll() { 
    return repository.findAll(); 
  }

  @GetMapping("/{id}") 
  public ResponseEntity<User> getById(@PathVariable Integer id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
  
  @PostMapping public User create(@RequestBody User item) {
     item.setUserID(null); return repository.save(item); 
    }
  @PutMapping("/{id}") public ResponseEntity<User> update(@PathVariable Integer id,@RequestBody User item) {
    if(!repository.existsById(id)) return ResponseEntity.notFound().build();
    item.setUserID(id);
    return ResponseEntity.ok(repository.save(item));
  }
  @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Integer id) {
    if(!repository.existsById(id)) return ResponseEntity.notFound().build();
    repository.deleteById(id); return ResponseEntity.noContent().build();
  }
}
