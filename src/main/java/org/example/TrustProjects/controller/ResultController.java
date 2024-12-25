package org.example.TrustProjects.controller;

import org.example.TrustProjects.DTO.ResultDTO;
import org.example.TrustProjects.IService.IResultService;
import org.example.TrustProjects.entity.Result;
import org.example.TrustProjects.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
     ResultService resultService;

    @Autowired
    IResultService iResultService;

    // POST API to store the result
    @PostMapping("/results")
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result savedResult = resultService.saveResult(result);
        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all results

    @GetMapping("/{enrollmentNumber}")
    public ResponseEntity<?> getResultByEnrollmentNumber(@PathVariable String enrollmentNumber) {
        Optional<ResultDTO> resultDTO = resultService.getResultByEnrollmentNumber(enrollmentNumber);

        if (resultDTO.isPresent()) {
            return ResponseEntity.ok(resultDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


