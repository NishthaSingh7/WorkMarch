package com.student.infosystem.studentinfosystem.controller;

import com.student.infosystem.studentinfosystem.util.ObjectMapperUtils;
import com.student.infosystem.studentinfosystem.model.Student;
import com.student.infosystem.studentinfosystem.dto.StudentDTO;
import com.student.infosystem.studentinfosystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping(value = "/")
    public List<StudentDTO> getAllStudents() {

        return ObjectMapperUtils.mapAll(studentService.findAll(), StudentDTO.class);
    }

    // Get a student by their student number
    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    public StudentDTO getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
        return ObjectMapperUtils.map(studentService.findByStudentNumber(studentNumber), StudentDTO.class);
    }

    // Get a student by their email
    @GetMapping(value = "/byEmail/{email}")
    public StudentDTO getStudentByEmail(@PathVariable("email") String email) {
        return ObjectMapperUtils.map(studentService.findByEmail(email), StudentDTO.class);
    }

    // Get all students based on their GPA in descending order
    @GetMapping(value = "/orderByGpa")
    public List<StudentDTO> findAllByOrderByGpaDesc() {
        return ObjectMapperUtils.mapAll(studentService.findAllByOrderByGpaDesc(), StudentDTO.class);
    }

    // Adding a student and saving the record to database
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveOrUpdateStudent(ObjectMapperUtils.map(studentDTO, Student.class));
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    // Updating a student's GPA by using their student number for filtering
    @PutMapping(value = "/{studentNumber}/updateGpa/{gpa}")
    public ResponseEntity<Student> updateStudentGpa(@PathVariable("studentNumber") Long studentNumber,
            @PathVariable("gpa") float gpa) {
        Student updatedStudent = studentService.update(studentNumber, gpa);
        return ResponseEntity.ok(updatedStudent);
    }

    // Delete a student by their student number
    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable long studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
    }

}