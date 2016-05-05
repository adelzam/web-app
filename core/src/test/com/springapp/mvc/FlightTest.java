package com.springapp.mvc;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.FlightRepository;
import com.springapp.mvc.services.AirportService;
import com.springapp.mvc.services.FlightService;
import com.springapp.mvc.services.RouteService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jca.cci.core.InteractionCallback;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by adelzamalutdinov on 05.05.16.
 */
public class FlightTest {

    private ApplicationContext applicationContext;

    @Test
    public void TestFlightService() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        FlightService flightService = applicationContext.getBean(FlightService.class);
        List<FlightInfo> flight = flightService.findFlight("Москва", "Казань");
        assertEquals(2L, flight.get(0).getId().longValue());
    }

    @Test
    public void TestFlightRepository() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        FlightRepository flightRepository = applicationContext.getBean(FlightRepository.class);
        RouteService routeService = applicationContext.getBean(RouteService.class);
        List<FlightInfo> flight = flightRepository.getFlightInfoByRoute(routeService.getRoute(1L, 2L));
        assertEquals(2L, flight.get(0).getId().longValue());
    }

    @Test
    public void TestAirportByName() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        AirportService airportService = applicationContext.getBean(AirportService.class);
        Double val = 1000.00;
        AirportInfo airportInfo = new AirportInfo(1L, "Домодедово", "Москва", val);
        assertEquals(airportInfo, airportService.getAirportByNameOrCity("Москва"));
    }

    @Test
    public void TestRoute() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        RouteService routeService = applicationContext.getBean(RouteService.class);
        assertEquals(1L, routeService.getRoute(1L, 2L).getId().longValue());
    }
}
