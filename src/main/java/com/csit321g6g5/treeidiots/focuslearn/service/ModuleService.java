
package com.csit321g6g5.treeidiots.focuslearn.service;

import com.csit321g6g5.treeidiots.focuslearn.entity.Module;
import com.csit321g6g5.treeidiots.focuslearn.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    public Module updateModule(Long id, Module updatedModule) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found"));

        module.setTitle(updatedModule.getTitle());
        module.setSequenceOrder(updatedModule.getSequenceOrder());
        module.setCourse(updatedModule.getCourse());

        return moduleRepository.save(module);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
