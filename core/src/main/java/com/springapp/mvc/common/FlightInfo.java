package com.springapp.mvc.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @Column(name = "plane")
    private String plane;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "check_in_num")
    private Integer check_in_num;

    public FlightInfo() {
    }

    public FlightInfo(Long number, RouteInfo route, String plane, Integer seats, Date date, Integer check_in_num) {
        this.number = number;
        this.route = route;
        this.plane = plane;
        this.seats = seats;
        this.date = date;
        this.check_in_num = check_in_num;
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

    public Integer getCheck_in_num() {
        return check_in_num;
    }

    public void setCheck_in_num(Integer check_in_num) {
        this.check_in_num = check_in_num;
    }
}
