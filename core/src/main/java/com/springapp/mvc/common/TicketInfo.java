package com.springapp.mvc.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class TicketInfo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
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
    private Boolean check_in;

    @Column(name="seat")
    private String seat;

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
}
