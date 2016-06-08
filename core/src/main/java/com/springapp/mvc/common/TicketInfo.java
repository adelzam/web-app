package com.springapp.mvc.common;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class TicketInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookInfo book;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private PassengersInfo passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightInfo flight;

    @ManyToOne
    @JoinColumn(name = "flight_class_id")
    private FlightClassInfo flight_class;

    @Column(name = "check_in")
    private Boolean check_in = false;

    @Column(name="seat")
    private String seat;

    @Column(name = "num")
    private Long num;

    public TicketInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookInfo getBook() {
        return book;
    }

    public void setBook(BookInfo book) {
        this.book = book;
    }

    public FlightInfo getFlight() {
        return flight;
    }

    public void setFlight(FlightInfo flight) {
        this.flight = flight;
    }

    public Boolean getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Boolean check_in) {
        this.check_in = check_in;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public PassengersInfo getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengersInfo passenger) {
        this.passenger = passenger;
    }

    public FlightClassInfo getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(FlightClassInfo flight_class) {
        this.flight_class = flight_class;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
