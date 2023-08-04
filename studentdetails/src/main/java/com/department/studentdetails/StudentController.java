package com.department.studentdetails;



import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // Create a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // Update an existing student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existingStudent = students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setDepartment(updatedStudent.getDepartment());
            // Update other attributes as needed
        }

        return existingStudent;
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    // Fetch details of a specific student
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Fetch details of all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // Fetch students by department ID
    @GetMapping("/department/{deptId}")
    public List<Student> getStudentsByDepartment(@PathVariable Long deptId) {
        List<Student> studentsInDepartment = new ArrayList<>();
        for (Student student : students) {
            if (student.getDepartment().getId().equals(deptId)) {
                studentsInDepartment.add(student);
            }
        }
        return studentsInDepartment;
    }
}

