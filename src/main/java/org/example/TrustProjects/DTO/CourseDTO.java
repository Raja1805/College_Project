package org.example.TrustProjects.DTO;

    public class CourseDTO {

        private String courseName;
        private double marks;
        private String grade;

        public CourseDTO(String courseName, double marks, String grade) {
            this.courseName = courseName;
            this.marks = marks;
            this.grade = grade;
        }

        // Getters and Setters
        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
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


