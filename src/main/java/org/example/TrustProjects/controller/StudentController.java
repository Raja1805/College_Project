package org.example.TrustProjects.controller;

import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.entity.Student;
import org.example.TrustProjects.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get students by institution ID
    @GetMapping("{enrollmentNumber}")
    public ResponseEntity<List<Student>> getStudentsByInstitution(@PathVariable String enrollmentNumber) {
        Student students = studentService.getStudentsByEnrollmentNumber(enrollmentNumber);
        return ResponseEntity.ok(Collections.singletonList(students));
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // Other endpoints can be added here if needed

    @PostMapping
    public ResponseEntity<ResponseDTO> createStudent(@RequestBody Student student){
        ResponseDTO res = studentService.createStudent(student);
        if(!res.isStatus()){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<ResponseDTO> updateStudent(@RequestBody Student student){
        ResponseDTO res = studentService.updateStudent(student);
        if(!res.isStatus()){
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }


    @PutMapping("/{studentId}")
    public ResponseEntity<ResponseDTO> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        ResponseDTO res = studentService.updateStudent(studentId, student);
        if (!res.isStatus()) {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}

