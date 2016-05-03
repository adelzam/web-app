package com.springapp.mvc.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "routes")
public class RouteInfo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AirportInfo departure;

    @ManyToOne(fetch = FetchType.EAGER)
    private AirportInfo arrival;

    @Column(name = "cost")
    private BigDecimal cost;

    public RouteInfo() {
    }

    public RouteInfo(AirportInfo departure, AirportInfo arrival, BigDecimal cost) {
        this.departure = departure;
        this.arrival = arrival;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirportInfo getDeparture() {
        return departure;
    }

    public void setDeparture(AirportInfo departure) {
        this.departure = departure;
    }

    public AirportInfo getArrival() {
        return arrival;
    }

    public void setArrival(AirportInfo arrival) {
        this.arrival = arrival;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}