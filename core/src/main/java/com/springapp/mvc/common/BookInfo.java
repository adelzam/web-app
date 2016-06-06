package com.springapp.mvc.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "book")
    private List<TicketInfo> ticket;

    public BookInfo() {
    }

    public BookInfo(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TicketInfo> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketInfo> ticket) {
        this.ticket = ticket;
    }
}
