package com.springapp.mvc.common;

import javax.persistence.*;

@Entity
@Table(name = "plane")
public class PlaneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "seatbusiness")
    private int business;

    @Column(name = "seatecomony")
    private int economy;

    @Column(name = "type")
    private String type;

    public PlaneInfo() {
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

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
