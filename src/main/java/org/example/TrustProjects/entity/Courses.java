package org.example.TrustProjects.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Courses {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long courseId;

        private String courseName;

    // Many courses belong to one institution
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

//    // A Course can have many Students
//    @ManyToMany
//    @JoinTable(
//            name = "student_courses", // Join table name
//            joinColumns = @JoinColumn(name = "course_id"), // Foreign key in student_courses for Courses
//            inverseJoinColumns = @JoinColumn(name = "student_id") // Foreign key in student_courses for Student
//    )
//    private List<Student> students;



    public Courses() {}

    public Courses(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

}

