package com.springapp.mvc.controllers;

import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.PlaneInfo;
import com.springapp.mvc.common.TicketInfo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.springapp.mvc.form.NewCheckInSearchForm;
import com.springapp.mvc.form.NewUpdateFlightForm;
import com.springapp.mvc.form.NewUpdatePassengerInfoForm;
import com.springapp.mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private AirportService airportService;

    @Autowired
    private PlaneService planeService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String printAdmin(ModelMap model) {
        List<TicketInfo> tickets = ticketService.getTickets();
        List<FlightInfo> flights = flightService.getFlights();
        List<PassengersInfo> passengers = passengersService.getPassengers();
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
        form.setBirth(passengersInfo.getBirth().toString());
        form.setPassport(passengersInfo.getPassport());
        request.setAttribute(ATTR_UPDATEPASSNEGERS_FORM,form);
        model.addAttribute("id", id);
        return "updatePassenger";
    }

    @RequestMapping(value = "update/passenger/{id}", method = RequestMethod.POST)
    public String printUpdateRes(@PathVariable("id") Long id, @Valid @ModelAttribute(ATTR_UPDATEPASSNEGERS_FORM) NewUpdatePassengerInfoForm updatePassengerInfoForm,
                                 BindingResult bindingResult, ModelMap model, HttpServletResponse response) throws IOException, ParseException {
        if (bindingResult.hasErrors()) {
            return "updatePassenger";
        }
        PassengersInfo passengersInfo = passengersService.getPassenger(id);
        passengersInfo.setLastName(updatePassengerInfoForm.getLastName());
        passengersInfo.setFirstName(updatePassengerInfoForm.getFirstName());
        passengersInfo.setPassport(updatePassengerInfoForm.getPassport());
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        passengersInfo.setBirth(format.parse(updatePassengerInfoForm.getBirth()));
        passengersService.updatePassengers(passengersInfo);
        response.sendRedirect("/admin");
        return "admin/mainadmin";
    }
    private static final String ATTR_UPDATEFLIGHT_FORM = "updateFForm";

    @RequestMapping(value = "update/flight/{id}", method = RequestMethod.GET)
    public String printUpdateFlightForm(ModelMap model, @PathVariable("id") Long id) throws ParseException {
        NewUpdateFlightForm form = new NewUpdateFlightForm();
        FlightInfo flightInfo = flightService.getFlightById(id);
        model.addAttribute("routes", routeService.getRoutes());
        model.addAttribute("planes", planeService.getAll());
        form.setNumber(flightInfo.getNumber().toString());
        form.setRoute(flightInfo.getRoute().getDeparture().getName()+" : "+flightInfo.getRoute().getArrival().getName());
        form.setArdate(flightInfo.getArdate().toString());
        form.setArtime(flightInfo.getArtime().toString());
        form.setDate(flightInfo.getDate().toString());
        form.setTime(flightInfo.getTime().toString());
        form.setPlane(flightInfo.getPlane().getName());
        request.setAttribute(ATTR_UPDATEFLIGHT_FORM,form);
        model.addAttribute("id", id);
        return "updateFlight";
    }

    @RequestMapping(value = "update/flight/{id}", method = RequestMethod.POST)
    public String printFlightRes(@PathVariable("id") Long id, @Valid @ModelAttribute(ATTR_UPDATEFLIGHT_FORM) NewUpdateFlightForm flightForm,
                                 BindingResult bindingResult, ModelMap model, HttpServletResponse response) throws IOException, ParseException {
        if (bindingResult.hasErrors()) {
            return "updateFlight";
        }
        FlightInfo info = flightService.getFlightById(id);
        flightService.updateFlight(updateFlightInfo(info, flightForm));
        response.sendRedirect("/admin");
        return "admin/mainadmin";
    }
    @RequestMapping(value = "add/flight", method = RequestMethod.GET)
    public String printAddFlightForm(ModelMap model) throws ParseException {
        model.addAttribute("routes", routeService.getRoutes());
        model.addAttribute("planes", planeService.getAll());
        request.setAttribute(ATTR_UPDATEFLIGHT_FORM,new NewUpdateFlightForm());
        return "addFlight";
    }

    @RequestMapping(value = "add/flight", method = RequestMethod.POST)
    public String printAddFlightRes(@Valid @ModelAttribute(ATTR_UPDATEFLIGHT_FORM) NewUpdateFlightForm flightForm,
                                 BindingResult bindingResult, ModelMap model, HttpServletResponse response) throws IOException, ParseException {
        if (bindingResult.hasErrors()) {
            return "addFlight";
        }
        flightService.updateFlight(updateFlightInfo(new FlightInfo(), flightForm));
        response.sendRedirect("/admin");
        return "admin/mainadmin";
    }
    private FlightInfo updateFlightInfo(FlightInfo info, NewUpdateFlightForm flightForm) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat();
        formatDate.applyPattern("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat();
        formatTime.applyPattern("HH:mm:ss");
        info.setNumber(Long.valueOf(flightForm.getNumber()));
        info.setArdate(formatDate.parse(flightForm.getArdate()));
        info.setArtime(formatTime.parse(flightForm.getArtime()));
        info.setDate(formatDate.parse(flightForm.getDate()));
        info.setTime(formatTime.parse(flightForm.getTime()));
        info.setPlane(planeService.getPlaneByName(flightForm.getPlane()));
        Long id1 = airportService.getAirportByName(flightForm.getRoute().replace(" ","").split(":")[0]).getId();
        Long id2 = airportService.getAirportByName(flightForm.getRoute().replace(" ","").split(":")[1]).getId();
        info.setRoute(routeService.getRoute(id1, id2));
        return info;
    }
}
