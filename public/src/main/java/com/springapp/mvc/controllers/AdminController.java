package com.springapp.mvc.controllers;

import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.TicketInfo;
import java.util.List;

import com.springapp.mvc.services.FlightService;
import com.springapp.mvc.services.PassengersService;
import com.springapp.mvc.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.krb5.internal.Ticket;

@Controller
@RequestMapping(value = "/admintest")
public class AdminController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengersService passengersService;

    @RequestMapping(method = RequestMethod.GET)
    public String printAdmin(ModelMap model) {
        List<TicketInfo> tickets = ticketService.getTickets();
        List<FlightInfo> flights = flightService.getFlights();
        List<PassengersInfo> passengers = passengersService.getPassengers();
        model.addAttribute("tickets", tickets);
        model.addAttribute("flights", flights);
        model.addAttribute("passengers", passengers);
        return "mainadmin";
    }
    @RequestMapping(value = "/delete/ticket/{id}", method = RequestMethod.GET)
    public String deleteTicket(ModelMap model, @PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        List<TicketInfo> tickets = ticketService.getTickets();
        List<FlightInfo> flights = flightService.getFlights();
        List<PassengersInfo> passengers = passengersService.getPassengers();
        model.addAttribute("tickets", tickets);
        model.addAttribute("flights", flights);
        model.addAttribute("passengers", passengers);
        return "mainadmin";
    }
    @RequestMapping(value = "/delete/flight/{id}", method = RequestMethod.GET)
    public String deleteFlight(ModelMap model, @PathVariable("id") Long id) {
        flightService.deleteFlight(id);
        List<TicketInfo> tickets = ticketService.getTickets();
        List<FlightInfo> flights = flightService.getFlights();
        List<PassengersInfo> passengers = passengersService.getPassengers();
        model.addAttribute("tickets", tickets);
        model.addAttribute("flights", flights);
        model.addAttribute("passengers", passengers);
        return "mainadmin";
    }
    @RequestMapping(value = "/delete/passenger/{id}", method = RequestMethod.GET)
    public String deletePassenger(ModelMap model, @PathVariable("id") Long id) {
        passengersService.deletePassengers(id);
        List<TicketInfo> tickets = ticketService.getTickets();
        List<FlightInfo> flights = flightService.getFlights();
        List<PassengersInfo> passengers = passengersService.getPassengers();
        model.addAttribute("tickets", tickets);
        model.addAttribute("flights", flights);
        model.addAttribute("passengers", passengers);
        return "mainadmin";
    }
}
