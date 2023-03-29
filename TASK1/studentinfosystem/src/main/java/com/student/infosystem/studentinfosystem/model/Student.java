package com.student.infosystem.studentinfosystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
// The @Document annotation specifies that 
//this object will be stored in a MongoDB collection named "students".

@Document(collection = "students")
public class Student {
    // The model for the Student object,
    // which has six attributes: id, name, studentNumber, email, courseList, and
    // gpa.
    @Id
    private String id; // auto generated
    private String name;
    private long studentNumber;
    private String email;
    private List<String> courseList;
    private float gpa;

    public Student() {
    }

    // Default Constructor
    public Student(String name, long studentNumber, String email, List<String> courseList, float gpa) {
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
    // get name
    public String getName() {
        return name;
    }

    // store name
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

    // Converting every data type toString
    // The Student class includesgetter and setter methods foreach attribute, as
    // well as a constructor and a toString() method.
    @Override
    public String toString() {
        return "Student{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                ", gpa=" + gpa +
                '}';
    }
}