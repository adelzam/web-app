package com.springapp.mvc.form;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TPFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String firstname;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String lastname;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])",
            message="Неверный формат даты рождения - YYYY-mm-dd")
    private String  bdate;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 10, max = 10, message = "Введите верный номер паспорта - 10 цифр")
    private String numdoc;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Неверный формат email")
    private String email;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    private String phone;

    public TPFormBean() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
