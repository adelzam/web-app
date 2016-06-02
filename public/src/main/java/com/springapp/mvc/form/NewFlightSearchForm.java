package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;
import java.util.Date;

public class NewFlightSearchForm {
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String departure;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String arrival;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private Date date;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private Integer passnum;

    public NewFlightSearchForm() {
    }

    public NewFlightSearchForm(String departure, String arrival, Date date, Integer passnum) {
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.passnum = passnum;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPassnum() {
        return passnum;
    }

    public void setPassnum(Integer passnum) {
        this.passnum = passnum;
    }
}
