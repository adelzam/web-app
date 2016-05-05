package com.springapp.mvc.services;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.AirportRepository;
import com.springapp.mvc.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adelzamalutdinov on 05.05.16.
 */
@Service
public class FlightService {

    @Autowired
    AirportService airportService;

    @Autowired
    RouteService routeService;

    @Autowired
    FlightRepository flightRepository;

    public List<FlightInfo> findFlight(String dep, String arr) {
        AirportInfo arrInfo = airportService.getAirportByNameOrCity(arr);
        AirportInfo depInfo = airportService.getAirportByNameOrCity(dep);
        if (arrInfo != null && depInfo != null) {
            RouteInfo route = routeService.getRoute(depInfo.getId(), arrInfo.getId());
            if (route != null) {
                return flightRepository.getFlightInfoByRoute(route);
            }
        }
        return null;
    }
}
