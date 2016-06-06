package com.springapp.mvc.controllers;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.form.TPFormBean;
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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/personal")
public class TicketPurchaseController {

    public static final String ATTR_REGISTRATION_FORM = "TPForm";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BookService bookService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private PassengersService passengersService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private  HttpSession session;


    /**
     * Отображение страницы заказа билета
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderRegistrationPage(@PathVariable("id") String id, ModelMap model) {
        session.setAttribute("flightIndex", id);
        System.out.println(id);
        request.setAttribute(ATTR_REGISTRATION_FORM, new TPFormBean());
        return "personal";
    }

    /**
     * Обработка формы заказа билета
     */
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) TPFormBean rfb,
            BindingResult bindingResult, ModelMap model) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "personal";
        }
        TicketInfo ticketInfo = new TicketInfo();
        BookInfo bookInfo = new BookInfo(bookService.generateBook());
        ticketInfo.setBook(bookInfo);
        bookService.saveBook(bookInfo);
        ticketInfo.setNum(ticketService.generateNum());
        SimpleDateFormat formatDate = new SimpleDateFormat();
        formatDate.applyPattern("yyyy-MM-dd");
        PassengersInfo passengersInfo = new PassengersInfo(rfb.getFirstname(), rfb.getLastname(), rfb.getNumdoc(), formatDate.parse(rfb.getBdate()));
        passengersService.updatePassengers(passengersInfo);
        ticketInfo.setPassenger(passengersService.getPassengerByPassport(rfb.getNumdoc()));
        String id = (String) session.getAttribute("flightIndex");
        System.out.println(id);
        Long flight = Long.valueOf(id.split(":")[0]);
        Long flightClass = Long.valueOf(id.split(":")[1])+1;
        ticketInfo.setFlight(flightService.getFlightById(flight));
        ticketInfo.setFlight_class(flightService.getFlightClassById(flightClass));
        ticketService.addTicket(ticketInfo);
        model.addAttribute("ticket", ticketInfo);
        return "finish";
    }
}
