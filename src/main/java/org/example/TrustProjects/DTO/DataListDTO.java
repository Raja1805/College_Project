package org.example.TrustProjects.DTO;

public class DataListDTO {

    Object data;
    private int length;
    private boolean status;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
