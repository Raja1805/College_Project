package org.example.TrustProjects.service;

import org.example.TrustProjects.DTO.CourseDTO;
import org.example.TrustProjects.DTO.ResultDTO;
import org.example.TrustProjects.IService.IResultService;
import org.example.TrustProjects.Repository.ResultRepository;
import org.example.TrustProjects.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultService implements IResultService {

    @Autowired
    private ResultRepository resultRepository;

    // Method to save result
    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    // Method to get result by enrollment number

    public Optional<ResultDTO> getResultByEnrollmentNumber(String enrollmentNumber) {
        return resultRepository.findByEnrollmentNumber(enrollmentNumber)
                .map(this::convertToDTO);
    }

    private ResultDTO convertToDTO(Result result) {
        ResultDTO dto = new ResultDTO();
        dto.setStudentName(result.getStudentName());
        dto.setEnrollmentNumber(result.getEnrollmentNumber());
        dto.setMarks(result.getMarks());
        dto.setGrade(result.getGrade());

        // Convert the courses to DTOs
        List<ResultDTO.CourseDTO> courseDTOs = result.getCourses().stream()
                .map(course -> {
                    ResultDTO.CourseDTO courseDTO = new ResultDTO.CourseDTO();
                    courseDTO.setCourseName(courseDTO.getCourseName());
                    courseDTO.setMarks(courseDTO.getMarks()); // Adjust if needed
                    courseDTO.setGrade(courseDTO.getGrade()); // Adjust if needed
                    return courseDTO;
                })
                .collect(Collectors.toList());

        dto.setCourses(courseDTOs);

        return dto;
    }
}

