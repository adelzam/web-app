package com.springapp.mvc.services;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Transactional
    public List<AirportInfo> getAirportByNameOrCity(String name) {
        List<AirportInfo> airportList = new ArrayList<AirportInfo>();
        AirportInfo airport = airportRepository.getAirportInfoByName(name);
        if (airport != null) {
            airportList.add(airport);
        }
        List<AirportInfo> city;
        if ((city = airportRepository.getAirportInfoByCity(name)) != null) {
            airportList.addAll(city);
        }
        return airportList;
    }

    @Transactional
    public List<AirportInfo> getAirports() {
        return airportRepository.findAll();
    }

    @Transactional
    public AirportInfo getAirportByName(String name) {
        return airportRepository.getAirportInfoByName(name);
    }
}
