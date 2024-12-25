package org.example.TrustProjects.service;


import org.example.TrustProjects.Repository.CourseRepository;
import org.example.TrustProjects.entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Save or update a course
    public Courses saveCourse(Courses course) {
        return courseRepository.save(course);
    }

    // Get a course by ID
    public Optional<Courses> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Get all courses
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    // Delete a course by ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

