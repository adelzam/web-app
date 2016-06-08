package com.springapp.mvc.common;

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

    @ManyToOne(cascade = {CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;

    public BookInfo(String name, List<TicketInfo> ticket) {
        this.name = name;
        this.ticket = ticket;
    }

    public BookInfo(String name, List<TicketInfo> ticket, UserInfo user) {
        this.name = name;
        this.ticket = ticket;
        this.user = user;
    }

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

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
