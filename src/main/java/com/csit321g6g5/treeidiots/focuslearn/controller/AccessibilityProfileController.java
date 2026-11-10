package com.csit321g6g5.treeidiots.focuslearn.controller;

import com.csit321g6g5.treeidiots.focuslearn.dto.AccessibilityProfileRequest;
import com.csit321g6g5.treeidiots.focuslearn.entity.AccessibilityProfile;
import com.csit321g6g5.treeidiots.focuslearn.entity.User;
import com.csit321g6g5.treeidiots.focuslearn.repository.AccessibilityProfileRepository;
import com.csit321g6g5.treeidiots.focuslearn.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accessibility-profiles")
@CrossOrigin
public class AccessibilityProfileController {
    private final AccessibilityProfileRepository profileRepository;
    private final UserRepository userRepository;

    public AccessibilityProfileController(AccessibilityProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<AccessibilityProfile> getAll() {
        return profileRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessibilityProfile> getById(@PathVariable Integer id) {
        return profileRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AccessibilityProfile> create(@RequestBody AccessibilityProfileRequest request) {
        if (request.getUserID() == null) {
            return ResponseEntity.badRequest().build();
        }

        User user = userRepository.findById(request.getUserID()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        AccessibilityProfile profile = new AccessibilityProfile();
        applyRequest(profile, request, user);
        return ResponseEntity.ok(profileRepository.save(profile));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessibilityProfile> update(@PathVariable Integer id, @RequestBody AccessibilityProfileRequest request) {
        AccessibilityProfile profile = profileRepository.findById(id).orElse(null);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }

        User user = profile.getUser();
        if (request.getUserID() != null) {
            user = userRepository.findById(request.getUserID()).orElse(null);
            if (user == null) {
                return ResponseEntity.badRequest().build();
            }
        }

        applyRequest(profile, request, user);
        return ResponseEntity.ok(profileRepository.save(profile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!profileRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        profileRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void applyRequest(AccessibilityProfile profile, AccessibilityProfileRequest request, User user) {
        profile.setUser(user);
        profile.setFontFamily(request.getFontFamily());
        profile.setFontSize(request.getFontSize());
        profile.setColorTheme(request.getColorTheme());
        if (request.getFocusModeDefault() != null) profile.setFocusModeDefault(request.getFocusModeDefault());
        if (request.getTtsSpeed() != null) profile.setTtsSpeed(request.getTtsSpeed());
        if (request.getLineSpacing() != null) profile.setLineSpacing(request.getLineSpacing());
        if (request.getLetterSpacing() != null) profile.setLetterSpacing(request.getLetterSpacing());
    }
}
