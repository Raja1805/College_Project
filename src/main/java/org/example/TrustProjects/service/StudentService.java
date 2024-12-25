package org.example.TrustProjects.service;

import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.Repository.StudentRepository;
import org.example.TrustProjects.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentsByEnrollmentNumber(String enrollmentNumber) {
        return studentRepository.getStudentsByEnrollmentNumber(enrollmentNumber);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public ResponseDTO createStudent(Student student) {
        ResponseDTO res = new ResponseDTO();
        studentRepository.save(student);
        res.setStatus(true);
        res.setMessage("Student created success");
        return res;
    }


    public ResponseDTO updateStudent(Student student) {
        ResponseDTO res = new ResponseDTO();
        Student updateStudent = studentRepository.getOne(student.getStudentId());
        if (student.getStudentName() != null) {
            updateStudent.setStudentName(student.getStudentName());
        }

        if (student.getStudentAddress() != null) {
            updateStudent.setStudentAddress(student.getStudentAddress());
        }
        if (student.getEmail() != null) {
            updateStudent.setEmail(student.getEmail());
        }
        if (student.getDob() != null) {
            updateStudent.setDob(student.getDob());
        }
        if (student.getAadharNumber() != null) {
            updateStudent.setAadharNumber(student.getAadharNumber());
        }
        if (student.getContactNumber() != null) {
            updateStudent.setContactNumber(student.getContactNumber());
        }
        if (student.getEnrollmentNumber() != null) {
            updateStudent.setEnrollmentNumber(student.getEnrollmentNumber());
        }
        if (student.getFatherName() != null) {
            updateStudent.setFatherName(student.getFatherName());
        }
        if (student.getMotherName() != null) {
            updateStudent.setMotherName(student.getMotherName());
        }
        if (student.getMedium() != null) {
            updateStudent.setMedium(student.getMedium());
        }
        if (student.getGender() != null) {
            updateStudent.setMediumOfStudy(student.getMediumOfStudy());
        }
        if (student.getNationality() != null) {
            updateStudent.setNationality(student.getNationality());
        }
        if (student.getQualification() != null) {
            updateStudent.setQualification(student.getQualification());
        }
        return res;
    }

    public ResponseDTO updateStudent(Long studentId, Student student) {
        ResponseDTO res = new ResponseDTO();

        // Fetch the student by the provided studentId
        Optional<Student> existingStudentOpt = studentRepository.findById(studentId);

        if (!existingStudentOpt.isPresent()) {
            res.setStatus(false);
            res.setMessage("Student not found");
            return res;
        }

        Student existingStudent = existingStudentOpt.get();

        // Update only the fields that are not null
        if (student.getStudentName() != null) {
            existingStudent.setStudentName(student.getStudentName());
        }
        if (student.getStudentAddress() != null) {
            existingStudent.setStudentAddress(student.getStudentAddress());
        }
        if (student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());
        }
        if (student.getDob() != null) {
            existingStudent.setDob(student.getDob());
        }
        if (student.getAadharNumber() != null) {
            existingStudent.setAadharNumber(student.getAadharNumber());
        }
        if (student.getContactNumber() != null) {
            existingStudent.setContactNumber(student.getContactNumber());
        }
        if (student.getEnrollmentNumber() != null) {
            existingStudent.setEnrollmentNumber(student.getEnrollmentNumber());
        }
        if (student.getFatherName() != null) {
            existingStudent.setFatherName(student.getFatherName());
        }
        if (student.getMotherName() != null) {
            existingStudent.setMotherName(student.getMotherName());
        }
        if (student.getMedium() != null) {
            existingStudent.setMedium(student.getMedium());
        }
        if (student.getGender() != null) {
            existingStudent.setGender(student.getGender());
        }
        if (student.getMediumOfStudy() != null) {
            existingStudent.setMediumOfStudy(student.getMediumOfStudy());
        }
        if (student.getNationality() != null) {
            existingStudent.setNationality(student.getNationality());
        }
        if (student.getQualification() != null) {
            existingStudent.setQualification(student.getQualification());
        }
        if (student.getSubject() != null) {
            existingStudent.setSubject(student.getSubject());
        }
        if (student.getSubjectShortForm() != null) {
            existingStudent.setSubjectShortForm(student.getSubjectShortForm());
        }

        // Save the updated student
        studentRepository.save(existingStudent);

        res.setStatus(true);
        res.setMessage("Student updated successfully");
        return res;
    }

}


