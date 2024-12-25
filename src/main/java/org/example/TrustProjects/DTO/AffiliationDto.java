package org.example.TrustProjects.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class AffiliationDto {

    private int affiliationId;

    private String email;

    private String institutionName;

    private String applicantName;
    private String mobileNumber;

    private String alternativeNumber;

    private String permanentAddress;

    private String city;

    private String state;

    private String postalCode;

    private String website;

    private String postalAddress;

    private String sector;

    private boolean activeStatus;

    private Date createdDate;

    private Date updatedDate;

//    @OneToMany(mappedBy = "affiliation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Courses> courses;

    private String courses;
    private MultipartFile profileImage;
    private MultipartFile institutionRegistration;
    private MultipartFile buildingRegistration;
    private MultipartFile idProof;
    private MultipartFile frontOfficePhoto;
    private MultipartFile classRoomPhoto;
    private MultipartFile nameBoard;
    private MultipartFile labPhoto;
    private MultipartFile ownerPhoto;

}
