package com.springapp.mvc.form;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by adelzamalutdinov on 06.06.16.
 */
public class NewUpdatePassengerInfoForm {

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z]+",
            message = "Неверный формат имени")
    private String firstName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z]+",
            message = "Неверный формат фамилии")
    private String lastName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[0-9]+",
            message = "Неверный формат номера документа")
    private String passport;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])",
            message = "Неверный формат номера документа")
    private Date birth;

    public NewUpdatePassengerInfoForm() {
    }

    public NewUpdatePassengerInfoForm(String firstName, String lastName, String passport, Date birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.birth = birth;
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
