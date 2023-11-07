package org.launchcode.techjobsauth.models;

import jakarta.persistence.Entity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class UserEntity extends AbstractEntity {

    private String userName;
    private String pwhash;

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.pwhash = encoder.encode(password);
    }



    public UserEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwhash);
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
}
