package com.springapp.mvc.common;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "flight")
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteInfo route;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private PlaneInfo plane;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "ardate")
    @Temporal(TemporalType.DATE)
    private Date ardate;

    @Column(name = "artime")
    @Temporal(TemporalType.TIME)
    private Date artime;

    @Column(name = "checkInNum")
    private Integer checkInNum;

    @Column(name = "checkInOpen")
    private Boolean checkInOpen;

    public FlightInfo() {
    }

    public FlightInfo(Long number, RouteInfo route, PlaneInfo plane, Date date, Date time, Date ardate, Date artime, Integer checkInNum, Boolean checkInOpen) {
        this.number = number;
        this.route = route;
        this.plane = plane;
        this.date = date;
        this.time = time;
        this.ardate = ardate;
        this.artime = artime;
        this.checkInNum = checkInNum;
        this.checkInOpen = checkInOpen;
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


    public PlaneInfo getPlane() {
        return plane;
    }

    public void setPlane(PlaneInfo plane) {
        this.plane = plane;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getCheckInOpen() {
        return checkInOpen;
    }

    public Date getArdate() {
        return ardate;
    }

    public void setArdate(Date ardate) {
        this.ardate = ardate;
    }

    public Date getArtime() throws ParseException {
        return artime;
    }

    public void setArtime(Date artime) {
        this.artime = artime;
    }

    public void setCheckInOpen(Boolean checkInOpen) {
        this.checkInOpen = checkInOpen;
    }
}
