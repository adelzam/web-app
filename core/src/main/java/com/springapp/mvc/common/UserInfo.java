package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ann on 06.06.2016.
 */
@Entity
@Table(name = "h_users")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;
    private String hashPass;
    private String fio;
    private String role;
    private String phone;

    public UserInfo(String login, String hashPass, String fio, String role, String phone) {
        this.login = login;
        this.hashPass = hashPass;
        this.fio = fio;
        this.role = role;
        this.phone = phone;
    }

    public UserInfo() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

