package org.example.TrustProjects.service;


import org.example.TrustProjects.Repository.InstitutionRepository;
import org.example.TrustProjects.entity.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    // Create or Update Institution
    public Institution saveInstitution(Institution institution) {
        // At this point, institution.getId() should return null if it's a new entity
        return institutionRepository.save(institution);
        // After saving, institution.getId() will return the generated ID
    }

    // Get Institution by ID
    public Optional<Institution> getInstitutionById(Long id) {
        return institutionRepository.findById(id);
    }

    // Get all Institutions
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    // Delete Institution by ID
    public void deleteInstitution(Long id) {
        institutionRepository.deleteById(id);
    }
}

