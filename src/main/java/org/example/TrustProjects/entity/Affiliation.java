package org.example.TrustProjects.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "affiliation")
public class Affiliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Lob
    @Column(name = "profile_image",length = 1000)
    private byte[] profileImage;


    @Lob
    @Column(name = "institution_registration")
    private byte[] institutionRegistration;

    @Lob
    @Column(name = "building_registration")
    private byte[] buildingRegistration;

    @Lob
    @Column(name = "id_proof")
    private byte[] idProof;
    @Lob
    @Column(name = "front_office_photo")
    private byte[] frontOfficePhoto;
    @Lob
    @Column(name = "class_room_photo")
    private byte[] classRoomPhoto;
    @Lob
    @Column(name = "name_board")
    private byte[] nameBoard;
    @Lob
    @Column(name = "lab_photo")
    private byte[] labPhoto;
    @Lob
    @Column(name = "owner_photo")
    private byte[] ownerPhoto;


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "USER_ROLE",
//            joinColumns = {
//                    @JoinColumn(name = "USER_ID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "ROLE_ID")
//            }
//    )
//
//    private Set<Role> role;

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }


    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName){
        this.applicantName = applicantName;
    }

    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAlternativeNumber() {
        return alternativeNumber;
    }

    public void setAlternativeNumber(String alternativeNumber) {
        this.alternativeNumber = alternativeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

//    public Set<Role> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<Role> role) {
//        this.role = role;
//    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress (String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

//    public List<Courses> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Courses> courses) {
//        this.courses = courses;
//    }


    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public byte[] getProfileImage(){
        return profileImage;
    }
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public byte[] getInstitutionRegistration(){
        return institutionRegistration;
    }
    public void setInstitutionRegistration(byte[] institutionRegistration) {
        this.institutionRegistration = institutionRegistration;
    }

    public byte[] getBuildingRegistration(){
        return buildingRegistration;
    }
    public void setBuildingRegistration(byte[] buildingRegistration) {
        this.buildingRegistration = buildingRegistration;
    }

    public byte[] getIdProof(){
        return idProof;
    }
    public void setIdProof(byte[] idProof) {
        this.idProof = idProof;
    }

    public byte[] getFrontOfficePhoto(){
        return frontOfficePhoto;
    }
    public void setFrontOfficePhoto(byte[] frontOfficePhoto) {
        this.frontOfficePhoto = frontOfficePhoto;
    }

    public byte[] getClassRoomPhoto(){
        return classRoomPhoto;
    }
    public void setClassRoomPhoto(byte[] classRoomPhoto) {
        this.classRoomPhoto = classRoomPhoto;
    }

    public byte[] getNameBoard(){
        return nameBoard;
    }
    public void setNameBoard(byte[] nameBoard) {
        this.nameBoard = nameBoard;
    }

    public byte[] getLabPhoto(){
        return labPhoto;
    }
    public void setLabPhoto(byte[] labPhoto) {
        this.labPhoto = labPhoto;
    }

    public byte[] getOwnerPhoto(){
        return ownerPhoto;
    }
    public void setOwnerPhoto(byte[] ownerPhoto) {
        this.ownerPhoto = ownerPhoto;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }

    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state=state;
    }


    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }



    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }
}
