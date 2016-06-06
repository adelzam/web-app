package com.springapp.mvc.form;


import com.springapp.mvc.common.PlaneInfo;
import com.springapp.mvc.common.RouteInfo;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class NewUpdateFlightForm {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[0-9]+",
            message = "Неверный формат имени")
    private String number;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String route;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])",
            message = "Неверный формат номера документа")
    private String date;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])",
            message = "Неверный формат номера документа")
    private String time;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])",
            message = "Неверный формат номера документа")
    private String ardate;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])",
            message = "Неверный формат номера документа")
    private String artime;

    public NewUpdateFlightForm() {
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArdate() {
        return ardate;
    }

    public void setArdate(String ardate) {
        this.ardate = ardate;
    }

    public String getArtime() {
        return artime;
    }

    public void setArtime(String artime) {
        this.artime = artime;
    }
}
