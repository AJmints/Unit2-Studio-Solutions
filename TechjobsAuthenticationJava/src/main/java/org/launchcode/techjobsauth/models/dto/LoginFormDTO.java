package org.launchcode.techjobsauth.models.dto;

public class LoginFormDTO {
    private String userName;
    private String password;

    public LoginFormDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginFormDTO() {
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

    public void setPassword(String password) {
        this.password = password;
    }
}

