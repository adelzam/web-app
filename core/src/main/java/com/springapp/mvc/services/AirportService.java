package com.springapp.mvc.services;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

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
}
