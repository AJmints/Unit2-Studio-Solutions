package org.launchcode.techjobsauth.models.dto;

public class RegisterFormDTO {
    private String userName;
    private String password;
    private String verifyPassword;

    public RegisterFormDTO(String userName, String password, String verifyPassword) {
        this.userName = userName;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public RegisterFormDTO() {
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
