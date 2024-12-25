package org.example.TrustProjects.Repository;

import org.example.TrustProjects.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentsByEnrollmentNumber(String enrollmentNumber);
}

