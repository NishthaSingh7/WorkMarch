package com.student.infosystem.studentinfosystem.service;

import com.student.infosystem.studentinfosystem.model.Student;

import java.util.List;

//Defines an interface called StudentService  
//Declares several methods for interacting with Student objects. 
public interface StudentService {

    List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

    Student update(Long studentNumber, float gpa);

    Student saveOrUpdateStudent(Student student);

    void deleteStudentById(String id);
}