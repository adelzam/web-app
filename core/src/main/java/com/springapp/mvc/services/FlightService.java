package com.springapp.mvc.services;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.common.FlightClassInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.FlightClassRepository;
import com.springapp.mvc.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private FlightClassRepository flightClassRepository;


    private final static long TIME_30_HOURS = 108000000L;
    private final static long TIME_40_MINUTE = 2400000L;

    @Transactional
    public List<FlightInfo> findFlight(String dep, String arr, Date date) {
        List<AirportInfo> arrInfo = airportService.getAirportByNameOrCity(arr);
        List<AirportInfo> depInfo = airportService.getAirportByNameOrCity(dep);
        List<FlightInfo> flight = new ArrayList<FlightInfo>();
        for (AirportInfo arrival : arrInfo) {
            for (AirportInfo departure : depInfo) {
                RouteInfo route = routeService.getRoute(departure.getId(), arrival.getId());
                if (route != null) {
                    flight.addAll(flightRepository.getFlightInfoByRouteAndDate(route, date));
                }
                if (flight.size() != 0) {
                    return flight;
                }
            }
        }
        return null;
    }

    @Transactional
    public FlightInfo getFlightById(Long id) {
        return flightRepository.findOne(id);
    }

    @Transactional
    public List<FlightInfo> getFlights() {
        return flightRepository.findAllByOrderByDate();
    }

    @Transactional
    public void updateCheckInInfo() {
        List<FlightInfo> flights = flightRepository.findAll();
        for (FlightInfo flight : flights) {
            long threehours = 10800000;
            long date = flight.getDate().getTime() + flight.getTime().getTime() + threehours;
            if ((date - TIME_30_HOURS) <= System.currentTimeMillis()
                    && (date - TIME_40_MINUTE) >= System.currentTimeMillis()) {
                flight.setCheckInOpen(true);
            } else {
                flight.setCheckInOpen(false);
            }
        }
    }
    @Transactional
    public List<FlightClassInfo> getFlightClassOrderById() {return flightClassRepository.getAllByOrderById();
    }

    @Transactional
    public void deleteFlight(Long id) {
        flightRepository.delete(id);
    }

    public void updateFlight(FlightInfo info) {
        flightRepository.save(info);
    }
}
