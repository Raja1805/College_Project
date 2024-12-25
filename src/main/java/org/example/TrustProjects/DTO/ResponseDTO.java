package org.example.TrustProjects.DTO;



public class ResponseDTO {

    private   String docCode;
    private String message;

    private Object data;
   private boolean Status;

   private String roleCode="2";

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status){
        this.Status = Status;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
