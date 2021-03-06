package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passengers")
public class PassengersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "passport")
    private String passport;

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;

    public PassengersInfo() {
    }

    public PassengersInfo(String firstName, String lastName, String passport, Date birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
