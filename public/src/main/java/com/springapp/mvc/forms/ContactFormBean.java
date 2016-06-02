package com.springapp.mvc.forms;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContactFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String fio;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String email;

    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    private String phone;

    @Size(min=5, max=1000, message="Сообщение должно быть от 5 до 1000 символов")
    private String message;

    public ContactFormBean() {
    }

    public ContactFormBean(String fio, String email, String phone, String message) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactFormBean{" +
                "fio='" + fio + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
