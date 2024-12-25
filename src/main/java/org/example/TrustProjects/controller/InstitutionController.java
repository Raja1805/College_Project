package org.example.TrustProjects.controller;

import org.example.TrustProjects.entity.Institution;
import org.example.TrustProjects.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    // Create or Update an Institution
    @PostMapping
    public ResponseEntity<Institution> createOrUpdateInstitution(@RequestBody Institution institution) {
        boolean isNewInstitution = (institution.getId() == null);  // Check if it's a new institution
        Institution savedInstitution = institutionService.saveInstitution(institution);

        if (isNewInstitution) {
            return new ResponseEntity<>(savedInstitution, HttpStatus.CREATED);  // Return 201 for new entity
        } else {
            return new ResponseEntity<>(savedInstitution, HttpStatus.OK);  // Return 200 for updated entity
        }
    }

    // Get an Institution by ID
    @GetMapping("/{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable Long id) {
        Optional<Institution> institution = institutionService.getInstitutionById(id);
        if (institution.isPresent()) {
            return new ResponseEntity<>(institution.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Get all Institutions
    @GetMapping
    public ResponseEntity<List<Institution>> getAllInstitutions() {
        List<Institution> institutions = institutionService.getAllInstitutions();
        return new ResponseEntity<>(institutions, HttpStatus.OK);
    }

    // Delete an Institution by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitution(@PathVariable Long id) {
        institutionService.deleteInstitution(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

