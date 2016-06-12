package com.springapp.mvc.form;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UpdateFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String fio;

    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    private String phone;

    @Size(min=3, max=20, message="Пароль должен быть от 3 до 20 символов")
    private String password;

    @Size(min=3, max=20, message="Пароль должен быть от 3 до 20 символов")
    private String confirmPassword;

    public UpdateFormBean(String fio, String phone, String password, String confirmPassword) {
        this.fio = fio;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UpdateFormBean() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UpdateFormBean{" +
                "fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
