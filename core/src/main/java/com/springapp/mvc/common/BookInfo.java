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

    @Column(name = "login")
    private String login;

    @OneToMany(mappedBy = "book")
    private List<TicketInfo> ticket;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public BookInfo(String name, String login) {
        this.name = name;
        this.login = login;
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

}
