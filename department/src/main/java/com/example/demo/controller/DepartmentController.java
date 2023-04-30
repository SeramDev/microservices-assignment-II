package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentServices departmentService;

    @PostMapping
    public Department create(@RequestBody Department department) {
        return departmentService.newDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return Optional.ofNullable(departmentService.findById(id));
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteById(id);
    }
}
