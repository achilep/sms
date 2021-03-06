package com.edufet.sms.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "userrole_tbl")
public class Userrole implements java.io.Serializable {

    @Id
    private String emailid;
    @Column
    private String role;
    @Column
    private String status = "True";
    @Column
    private String password;
    @Transient
    MultipartFile image;

    public String getEmailid() {
        return this.emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
    
    
}
