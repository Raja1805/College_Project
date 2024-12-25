package org.example.TrustProjects.controller;

import org.example.TrustProjects.DTO.AffiliationDto;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.IAffiliationService;
import org.example.TrustProjects.entity.Affiliation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Affiliation")
public class AffiliationController {

    @Autowired
    private IAffiliationService iAffiliationService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/list")
    public ResponseEntity<List<Affiliation>> getAllAffiliationUsers() {
        List<Affiliation> list = iAffiliationService.getAllAffiliationUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody Affiliation affiliation) {
        ResponseDTO response = iAffiliationService.updateUser(affiliation);
        if (!response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Affiliation> submitAffiliation(AffiliationDto affiliationDto, @RequestParam("ownerPhoto") MultipartFile ownerPhotoImg,
                                                         @RequestParam("labPhoto") MultipartFile labPhotoImg, @RequestParam("classRoomPhoto") MultipartFile classRoomPhoto,
                                                         @RequestParam("profileImage") MultipartFile profileImageImg, @RequestParam("institutionRegistration") MultipartFile institutionRegistrationImg,
                                                         @RequestParam("buildingRegistration") MultipartFile buildingRegistrationImg, @RequestParam("idProof") MultipartFile idProofImg,
                                                         @RequestParam("nameBoard") MultipartFile nameBoardImg, @RequestParam("frontOfficePhoto") MultipartFile frontOfficePhotoImg) throws IOException {
        Affiliation affiliation = modelMapper.map(affiliationDto, Affiliation.class);
        affiliation.setOwnerPhoto(ownerPhotoImg.getBytes());
        affiliation.setLabPhoto(labPhotoImg.getBytes());
        affiliation.setClassRoomPhoto(classRoomPhoto.getBytes());
        affiliation.setProfileImage(profileImageImg.getBytes());
        affiliation.setInstitutionRegistration(institutionRegistrationImg.getBytes());
        affiliation.setBuildingRegistration(buildingRegistrationImg.getBytes());
        affiliation.setIdProof(idProofImg.getBytes());
        affiliation.setNameBoard(nameBoardImg.getBytes());
        affiliation.setFrontOfficePhoto(frontOfficePhotoImg.getBytes());
        Affiliation savedAffiliation = iAffiliationService.saveAffiliationUser(affiliation);
        return ResponseEntity.ok(savedAffiliation);
    }

    @GetMapping("/{affiliationId}")
    public ResponseEntity<Affiliation> getUserById(@PathVariable int affiliationId) {
        Optional<Affiliation> userOptional = iAffiliationService.getUserById(affiliationId);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/uploadDocument")
    public ResponseEntity<String> uploadDocument(@RequestParam int affiliationId,
                                                 @RequestParam String documentType,
                                                 @RequestParam("file") MultipartFile file) {
        try {
            iAffiliationService.uploadDocument(affiliationId, file, documentType);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while uploading file");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
