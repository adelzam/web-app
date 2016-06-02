package com.springapp.mvc.services;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Transactional
    public AirportInfo getAirportByNameOrCity(String name) {
        AirportInfo airport = airportRepository.getAirportInfoByName(name);
        if (airport == null) {
            airport = airportRepository.getAirportInfoByCity(name);
        }
        if (airport == null) {
            return null;
        }
        return airport;
    }

    @Transactional
    public List<AirportInfo> getAirports() {
        return airportRepository.findAll();
    }
}
