package com.department.studentdetails;

// Student.java
class Student {
    private Long id;
    private String name;
    private int age;
    private Department department;


    public Student() {
    }

    public Student(Long id, String name, int age, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Add getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // Add toString method for easy debugging
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
