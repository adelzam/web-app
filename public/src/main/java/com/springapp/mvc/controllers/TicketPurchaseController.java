package com.springapp.mvc.controllers;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.form.TPFormBean;
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
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;

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
    private HttpSession session;


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
//        Создали билет, создали бронирование, добавили бронирование к билету
        TicketInfo ticketInfo = new TicketInfo();
        BookInfo bookInfo = new BookInfo(bookService.generateBook(), rfb.getEmail());
        ticketInfo.setBook(bookInfo);
        bookService.saveBook(bookInfo);
        ticketInfo.setNum(ticketService.generateNum());
//        Создали пассажира, добавили пассажира к билету.
//        Если пасажир с таки мпаспортом уже имеется то юзаем его а не создаем нового
        PassengersInfo passengersInfo;
        if (passengersService.getPassengerByPassport(rfb.getNumdoc()) != null) {
            passengersInfo = passengersService.getPassengerByPassport(rfb.getNumdoc());
        } else {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
            DateTime dt = fmt.parseDateTime(rfb.getBdate());
            passengersInfo = new PassengersInfo(rfb.getFirstname(), rfb.getLastname(), rfb.getNumdoc(), dt.toDate());
            passengersService.updatePassengers(passengersInfo);
        }
        ticketInfo.setPassenger(passengersInfo);
//        По индексам нашли выбранный рейс и выбранный класс и добавили их к билету
        String id = (String) session.getAttribute("flightIndex");
        Long flight = Long.valueOf(id.split(":")[0]);
        Long flightClass = Long.valueOf(id.split(":")[1]) + 1;
        ticketInfo.setFlight(flightService.getFlightById(flight));
        ticketInfo.setFlight_class(flightService.getFlightClassById(flightClass));
//        Билет готов, занесли его в бд
        ticketService.addTicket(ticketInfo);
        model.addAttribute("ticket", ticketService.getTicketInfoBuNum(ticketInfo.getNum()));
        return "finish";
    }
}
