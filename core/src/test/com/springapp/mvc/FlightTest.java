package com.springapp.mvc;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.AirportRepository;
import com.springapp.mvc.repository.FlightRepository;
import com.springapp.mvc.repository.RoutesRepository;
import com.springapp.mvc.services.AirportService;
import com.springapp.mvc.services.FlightService;
import com.springapp.mvc.services.RouteService;
import org.apache.log4j.helpers.DateTimeDateFormat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightTest {


    private ApplicationContext applicationContext;

    @Test
    public void TestFlightService() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        FlightService flightService = applicationContext.getBean(FlightService.class);
        List<FlightInfo> flight = flightService.findFlight("Москва", "Казань", new GregorianCalendar(2016, Calendar.MAY, 6).getTime());
        assertEquals(2L, flight.get(0).getId().longValue());
    }

    @Test
    public void TestAirport() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        AirportService airportService = applicationContext.getBean(AirportService.class);
        Double val = 1000.00;
        AirportInfo airportInfo = new AirportInfo(2L, "Домодедово", "Москва", val);
        assertEquals(airportInfo, airportService.getAirportByNameOrCity("Москва"));
    }

    @Test
    public void TestRoute() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        RouteService routeService = applicationContext.getBean(RouteService.class);
        assertEquals(1L, routeService.getRoute(2L, 3L).getId().longValue());
    }

    @Test
    public void TestFlightRepository() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        FlightRepository flightRepository = applicationContext.getBean(FlightRepository.class);
        RouteService routeService = applicationContext.getBean(RouteService.class);
        List<FlightInfo> flight = flightRepository.getFlightInfoByRouteAndDate(routeService.getRoute(2L, 3L), new GregorianCalendar(2016, Calendar.MAY, 6).getTime());
        assertEquals(2L, flight.get(0).getId().longValue());
    }

    @Test
    public void TestAirportRepositoryByName() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        AirportRepository airportRepository = applicationContext.getBean(AirportRepository.class);
        assertEquals(3L, airportRepository.getAirportInfoByName("Казань").getId().longValue());
    }

    @Test
    public void TestAirportRepositoryByCity() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        AirportRepository airportRepository = applicationContext.getBean(AirportRepository.class);
        assertEquals(2L, airportRepository.getAirportInfoByCity("Москва").getId().longValue());
    }

    @Test
    public void TestRouteRepository() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        RoutesRepository routesRepository = applicationContext.getBean(RoutesRepository.class);
        assertEquals(1L, routesRepository.findRouteInfoByArrivalIdAndDepartureId(2L, 3L).getId().longValue());
    }
}
