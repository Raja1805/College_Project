package org.example.TrustProjects.service;

import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.IAffiliationService;
import org.example.TrustProjects.Repository.AffiliationRepository;
import org.example.TrustProjects.TrustProject;
import org.example.TrustProjects.entity.Affiliation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class AffiliationService implements IAffiliationService {

    @Autowired
    private AffiliationRepository affiliationRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Affiliation> getAllAffiliationUsers() {
        return affiliationRepository.findAll();
    }

    @Override
    public ResponseDTO updateUser(Affiliation affiliation) {
        ResponseDTO res = new ResponseDTO();
        Optional<Affiliation> existingUserOpt = affiliationRepository.findById(affiliation.getAffiliationId());

        if (existingUserOpt.isPresent()) {
            Affiliation existingUser = existingUserOpt.get();
            updateFields(existingUser, affiliation); // helper method to update fields
            existingUser.setUpdatedDate(new Date());
            affiliationRepository.save(existingUser);
            res.setStatus(true);
            res.setMessage("Update successful");
        } else {
            res.setStatus(false);
            res.setMessage("Affiliation not found");
        }

        return res;
    }

    private void updateFields(Affiliation existingUser, Affiliation newUser) {
        if (newUser.getApplicantName() != null) existingUser.setApplicantName(newUser.getApplicantName());
        if (newUser.getAlternativeNumber() != null) existingUser.setAlternativeNumber(newUser.getAlternativeNumber());
        if (newUser.getEmail() != null) existingUser.setEmail(newUser.getEmail());
        if (newUser.getPostalAddress() != null) existingUser.setPostalAddress(newUser.getPostalAddress());
        if (newUser.getCity() != null) existingUser.setCity(newUser.getCity());
        if (newUser.getPostalCode() != null) existingUser.setPostalCode(newUser.getPostalCode());
        if (newUser.getState() != null) existingUser.setState(newUser.getState());
    }

    @Override
    public Affiliation saveAffiliationUser(Affiliation user) {
        user.setActiveStatus(true); // Set the user as active
        user.setCreatedDate(new Date());
        Affiliation savedAffiliation = affiliationRepository.save(user);

        // Send an email notification
        sendEmailNotification(savedAffiliation);

        return savedAffiliation;
    }

    private void sendEmailNotification(Affiliation affiliation) {
        String text = "Hi,<br><br>"
                + "We are happy to welcome you to ICVTE and appreciate your submission of documents as part of the registration process.<br><br>"
                + "Our team is currently reviewing the documents you submitted to ensure that all details are accurate and complete. This verification process usually takes 4 to 5 working days,and we will inform you as soon as the review is finished.<br><br>"
                + "If you have any questions or need further assistance, please contact us at Info@icvte.com or +91 97898 32552. We are here to help!<br><br>" +

                "Thank you for your patience and cooperation.<br><br>"
                + "Warm regards<br><br>"+"<img width=80 height=80 src=\"cid:image\">";

        MimeMultipart multipart = new MimeMultipart("related");

        try {
            DataSource source = new FileDataSource(new File(getClass().getClassLoader().getResource("logo.png").getFile()));


            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(text, "text/html; charset=utf-8");

            // add it
            multipart.addBodyPart(messageBodyPart);
            //System.out.println("fds"+fds.getName());
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add it
            multipart.addBodyPart(messageBodyPart);

        } catch (
                MessagingException e) {
            throw new RuntimeException(e);
        }

        String to = affiliation.getEmail();
        String subject = "Welcome to ICVTE - Document Verification in Process";
        emailService.sendSimpleMessage(to, subject, text, multipart);
    }

    @Override
    public Optional<Affiliation> getUserById(int affiliationId) {
        return affiliationRepository.findById(affiliationId);
    }

    @Override
    public void uploadDocument(int affiliationId, MultipartFile file, String documentType) throws IOException {
        Optional<Affiliation> userOptional = affiliationRepository.findById(affiliationId);
        if (userOptional.isPresent()) {
            Affiliation user = userOptional.get();
            byte[] fileContent = file.getBytes();

            switch (documentType) {
                case "profileImage":
                    user.setProfileImage(fileContent);
                    break;
                case "institutionRegistration":
                    user.setInstitutionRegistration(fileContent);
                    break;
                case "buildingRegistration":
                    user.setBuildingRegistration(fileContent);
                    break;
                case "idProof":
                    user.setIdProof(fileContent);
                    break;
                case "frontOfficePhoto":
                    user.setFrontOfficePhoto(fileContent);
                    break;
                case "classRoomPhoto":
                    user.setClassRoomPhoto(fileContent);
                    break;
                case "nameBoard":
                    user.setNameBoard(fileContent);
                    break;
                case "labPhoto":
                    user.setLabPhoto(fileContent);
                    break;
                case "ownerPhoto":
                    user.setOwnerPhoto(fileContent);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid document type");
            }

            user.setUpdatedDate(new Date());
            affiliationRepository.save(user);
        } else {
            throw new IllegalArgumentException("Affiliation not found");
        }
    }
}
