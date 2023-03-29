package com.student.infosystem.studentinfosystem.service.impl;

import com.student.infosystem.studentinfosystem.model.Student;
import com.student.infosystem.studentinfosystem.repository.StudentRepository;
import com.student.infosystem.studentinfosystem.service.StudentService;
import com.student.infosystem.studentinfosystem.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Implementation of the StudentService interface. 
//Helps to perform CRUD operations on the StudentRepository, 

//The methods use the StudentRepository to interact with the database 
//and the ObjectMapperUtils to map objects between the model and DTO layers. 
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByStudentNumber(long studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> findAllByOrderByGpaDesc() {
        return studentRepository.findAllByOrderByGpaDesc();
    }

    @Override
    public Student update(Long studentNumber, float gpa) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        student.setGpa(gpa);
        Student updatedStudent = studentRepository.save(student);
        return ObjectMapperUtils.map(updatedStudent, Student.class);
    }

    @Override
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
}