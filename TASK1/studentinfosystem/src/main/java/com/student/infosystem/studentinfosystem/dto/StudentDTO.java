package com.student.infosystem.studentinfosystem.dto;

import java.util.List;

public class StudentDTO {
    private String id;
    private String name;
    private long studentNumber;
    private String email;
    private List<String> courseList;
    private float gpa;

    public StudentDTO() {
    }

    // Student schema with 6 values, where id is generated on its own
    public StudentDTO(String id, String name, long studentNumber, String email,
            List<String> courseList, float gpa) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
        this.courseList = courseList;
        this.gpa = gpa;
    }

    // Attribute - Id
    // get Id
    public String getId() {
        return id;
    }

    // set Id
    public void setId(String id) {
        this.id = id;
    }

    // Attribute - Name
    // get Name
    public String getName() {
        return name;
    }

    // store Name
    public void setName(String name) {
        this.name = name;
    }

    // Attribute - StudentNumber
    // get StudentNumber
    public long getStudentNumber() {
        return studentNumber;
    }

    // store StudentNumber
    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    // Attribute - Email
    // get Email
    public String getEmail() {
        return email;
    }

    // set Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Attribute - Course List
    // get List of Courses
    public List<String> getCourseList() {
        return courseList;
    }

    // store courses
    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    // Attribute - GPA
    // get GPA
    public float getGpa() {
        return gpa;
    }

    // store GPA
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

}