package com.springapp.mvc.common;

import javax.persistence.*;


@Entity
@Table(name = "airport")
public class AirportInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name ="taxes")
    private String taxes;

    public AirportInfo() {
    }

    public AirportInfo(String name, String taxes) {
        this.name = name;
        this.taxes = taxes;
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

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }
}
