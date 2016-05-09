package com.springapp.mvc.services;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private AirportService airportService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private FlightRepository flightRepository;

    private final static long TIME_30_HOURS = 108000000L;
    private final static long TIME_40_MINUTE = 2400000L;


    public List<FlightInfo> findFlight(String dep, String arr, Date date) {
        AirportInfo arrInfo = airportService.getAirportByNameOrCity(arr);
        AirportInfo depInfo = airportService.getAirportByNameOrCity(dep);
        if (arrInfo != null && depInfo != null) {
            RouteInfo route = routeService.getRoute(depInfo.getId(), arrInfo.getId());
            if (route != null) {
                return flightRepository.getFlightInfoByRouteAndDate(route, date);
            }
        }
        return null;
    }

    public FlightInfo getFlightById(Long id) {
        return flightRepository.findOne(id);
    }

    public void updateCheckInInfo() {
        List<FlightInfo> flights = flightRepository.findAll();
        for (FlightInfo flight : flights) {
            long date = flight.getDate().getTime() + flight.getTime().getTime();
            if ((date - TIME_30_HOURS) <= System.currentTimeMillis()
                    && (date - TIME_40_MINUTE) >= System.currentTimeMillis()) {
                flight.setCheckInOpen(true);
            } else {
                flight.setCheckInOpen(false);
            }
        }
    }
}
