package com.student.infosystem.studentinfosystem.repository;

import com.student.infosystem.studentinfosystem.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
// interface definition for the Student Repository, 
//which extends the MongoRepository interface from Spring Data. 

// No need implementation, just one interface, 
// as Spring Data automatically provides the necessary CRUD operations.
public interface StudentRepository extends MongoRepository<Student, String> {

    // It includes three methods that allow for easy access to student data in the
    // MongoDB database.

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

}