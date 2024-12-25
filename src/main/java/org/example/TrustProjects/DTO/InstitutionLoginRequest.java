package org.example.TrustProjects.DTO;

public class InstitutionLoginRequest {

    private String institutionUserName;
    private String institutionPassword;

    public String getInstitutionUserName() {
        return institutionUserName;
    }

    public void setInstitutionUserName(String institutionUserName) {
        this.institutionUserName = institutionUserName;
    }

    public String getInstitutionPassword() {
        return institutionPassword;
    }

    public void setInstitutionPassword(String institutionPassword) {
        this.institutionPassword = institutionPassword;
    }
}
