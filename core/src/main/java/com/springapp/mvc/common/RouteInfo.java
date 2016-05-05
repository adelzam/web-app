package com.springapp.mvc.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "routes")
public class RouteInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AirportInfo departure;

    @ManyToOne(fetch = FetchType.EAGER)
    private AirportInfo arrival;

    @Column(name = "cost")
    private Double cost;

    public RouteInfo() {
    }

    public RouteInfo(AirportInfo departure, AirportInfo arrival, Double cost) {
        this.departure = departure;
        this.arrival = arrival;
        this.cost = cost;
    }

    public RouteInfo(Long id, AirportInfo departure, AirportInfo arrival, Double cost) {
        this.id = id;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteInfo routeInfo = (RouteInfo) o;

        if (!id.equals(routeInfo.id)) return false;
        if (departure != null ? !departure.equals(routeInfo.departure) : routeInfo.departure != null) return false;
        if (arrival != null ? !arrival.equals(routeInfo.arrival) : routeInfo.arrival != null) return false;
        return cost != null ? cost.equals(routeInfo.cost) : routeInfo.cost == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}