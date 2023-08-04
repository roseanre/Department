package com.department.studentdetails;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private List<Department> departments = new ArrayList<>();

    // Create a new department
    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        departments.add(department);
        return department;
    }

    // Update an existing department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        Department existingDepartment = departments.stream()
                .filter(dept -> dept.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingDepartment != null) {
            existingDepartment.setName(updatedDepartment.getName());

        }

        return existingDepartment;
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departments.removeIf(dept -> dept.getId().equals(id));
    }

    // Fetch details of a specific department
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departments.stream()
                .filter(dept -> dept.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Fetch details of all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departments;
    }
}
