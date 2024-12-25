package org.example.TrustProjects.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "CourseResults")
public class ResultCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultCourseId;

    private String courseName;

    @ManyToOne
    @JoinColumn(name = "result_id") // Foreign key column
    private Result result;

    private double marks;
    private String grade;

    public Long getResultCourseId() {
        return resultCourseId;
    }

    public void setResultCourseId(Long resultCourseId) {
        this.resultCourseId = resultCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
