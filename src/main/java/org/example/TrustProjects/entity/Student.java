package org.example.TrustProjects.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Getter
@Setter
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String studentName;

    private String enrollmentNumber;
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Institution institution;
    private String gender;
    private String motherName;
    private String fatherName;
    private String aadharNumber;
    private String nationality;
    private String mediumOfStudy;
    private String qualification;
    private String childstudy;
    private String artstudy;
    private String healthstudy;
    private String mediastudy;
    private String beautystudy;
    private String automobilestudy;
    private String firestudy;
    private String agrystudy;
    private String comstudy;
    private String sportsstudy;
    private String computerstudy;
    private String hospitalstudy;
    private String languagestudy;

    @Lob
    private byte[] photo;
    private String subject;
    private String subjectShortForm;

    private String medium;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String contactNumber;
    private String email;
    private String studentAddress;


    
    // private String courses;
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMediumOfStudy() {
        return mediumOfStudy;
    }

    public void setMediumOfStudy(String mediumOfStudy) {
        this.mediumOfStudy = mediumOfStudy;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getChildstudy() {
        return childstudy;
    }

    public void setChildstudy(String childstudy) {
        this.childstudy = childstudy;
    }

    public String getArtstudy() {
        return artstudy;
    }

    public void setArtstudy(String artstudy) {
        this.artstudy = artstudy;
    }

    public String getHealthstudy() {
        return healthstudy;
    }

    public void setHealthstudy(String healthstudy) {
        this.healthstudy = healthstudy;
    }

    public String getMediastudy() {
        return mediastudy;
    }

    public void setMediastudy(String mediastudy) {
        this.mediastudy = mediastudy;
    }

    public String getBeautystudy() {
        return beautystudy;
    }

    public void setBeautystudy(String beautystudy) {
        this.beautystudy = beautystudy;
    }

    public String getAutomobilestudy() {
        return automobilestudy;
    }

    public void setAutomobilestudy(String automobilestudy) {
        this.automobilestudy = automobilestudy;
    }

    public String getFirestudy() {
        return firestudy;
    }

    public void setFirestudy(String firestudy) {
        this.firestudy = firestudy;
    }

    public String getAgrystudy() {
        return agrystudy;
    }

    public void setAgrystudy(String agrystudy) {
        this.agrystudy = agrystudy;
    }

    public String getComstudy() {
        return comstudy;
    }

    public void setComstudy(String comstudy) {
        this.comstudy = comstudy;
    }

    public String getSportsstudy() {
        return sportsstudy;
    }

    public void setSportsstudy(String sportsstudy) {
        this.sportsstudy = sportsstudy;
    }

    public String getComputerstudy() {
        return computerstudy;
    }

    public void setComputerstudy(String computerstudy) {
        this.computerstudy = computerstudy;
    }

    public String getHospitalstudy() {
        return hospitalstudy;
    }

    public void setHospitalstudy(String hospitalstudy) {
        this.hospitalstudy = hospitalstudy;
    }

    public String getLanguagestudy() {
        return languagestudy;
    }

    public void setLanguagestudy(String languagestudy) {
        this.languagestudy = languagestudy;
    }


    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    // public String getSubject() {
    //     return subject;
    // }

    // public void setSubject(String subject) {
    //     this.subject = subject;
    // }

    public String getSubjectShortForm() {
        return subjectShortForm;
    }

    public void setSubjectShortForm(String subjectShortForm) {
        this.subjectShortForm = subjectShortForm;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    // public String getCourses() {
    //     return courses;
    // }

    // public void setCourses(String courses) {
    //     this.courses = courses;
    // }
}
