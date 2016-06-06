package com.springapp.mvc.controllers;

import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.TicketInfo;

import java.util.List;

import com.springapp.mvc.form.NewCheckInSearchForm;
import com.springapp.mvc.form.NewUpdatePassengerInfoForm;
import com.springapp.mvc.services.BookService;
import com.springapp.mvc.services.FlightService;
import com.springapp.mvc.services.PassengersService;
import com.springapp.mvc.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengersService passengersService;

    @Autowired
    private BookService bookService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String printAdmin(ModelMap model) {
        List<TicketInfo> tickets = ticketService.getTickets();
        List<FlightInfo> flights = flightService.getFlights();
        List<PassengersInfo> passengers = passengersService.getPassengers();
        System.out.println(bookService.generateBook());
        model.addAttribute("tickets", tickets);
        model.addAttribute("flights", flights);
        model.addAttribute("passengers", passengers);
        return "admin/mainadmin";
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
        return "admin/mainadmin";
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
        return "admin/mainadmin";
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
        return "admin/mainadmin";
    }

    private static final String ATTR_UPDATEPASSNEGERS_FORM = "updatePForm";

    @RequestMapping(value = "update/passenger/{id}", method = RequestMethod.GET)
    public String printUpdatePassengerForm(ModelMap model, @PathVariable("id") Long id) {
        NewUpdatePassengerInfoForm form = new NewUpdatePassengerInfoForm();
        PassengersInfo passengersInfo = passengersService.getPassenger(id);
        form.setLastName(passengersInfo.getLastName());
        form.setFirstName(passengersInfo.getFirstName());
        form.setBirth(passengersInfo.getBirth());
        form.setPassport(passengersInfo.getPassport());
        request.setAttribute(ATTR_UPDATEPASSNEGERS_FORM,form);
        model.addAttribute("id", id);
        return "updatePassenger";
    }

    @RequestMapping(value = "update/passenger/{id}", method = RequestMethod.POST)
    public String printUpdateRes(@Valid @ModelAttribute(ATTR_UPDATEPASSNEGERS_FORM) NewUpdatePassengerInfoForm updatePassengerInfoForm,
                                 BindingResult bindingResult, ModelMap model){
        if (bindingResult.hasErrors()) {
            return "updatePassenger";
        }
        return "admin/mainadmin";
    }
}
