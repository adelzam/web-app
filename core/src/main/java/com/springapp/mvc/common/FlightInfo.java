package com.springapp.mvc.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class FlightInfo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    @Column(name = "number")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteInfo route;

    @Column(name = "plane")
    private String plane;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "date")
    private Date date;

    @Column(name = "checkInNum")
    private Integer checkInNum;

    @Column(name = "checkInOpen")
    private Boolean checkInOpen;

    public FlightInfo() {
    }

    public FlightInfo(Long number, RouteInfo route, String plane, Integer seats, Date date, Integer checkInNum) {
        this.number = number;
        this.route = route;
        this.plane = plane;
        this.seats = seats;
        this.date = date;
        this.checkInNum = checkInNum;
        this.checkInOpen = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public RouteInfo getRoute() {
        return route;
    }

    public void setRoute(RouteInfo route) {
        this.route = route;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCheckInNum() {
        return checkInNum;
    }

    public void setCheckInNum(Integer checkInNum) {
        this.checkInNum = checkInNum;
    }

    public Boolean getCheckInOpen() {
        return checkInOpen;
    }

    public void setCheckInOpen(Boolean checkInOpen) {
        this.checkInOpen = checkInOpen;
    }
}
