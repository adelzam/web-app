package com.springapp.mvc.controllers;

import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PrintDocController {
    @Autowired
    TicketService ticketService;
    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public String showTicket(Model model, HttpSession session, @PathVariable("id") Long id) {
        TicketInfo ticket = ticketService.getTicketInfo(id);
        model.addAttribute("ticket",ticket );
        Date checkTime= new Date(ticket.getFlight().getTime().getTime() - 2400000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        model.addAttribute("checkIn",String.valueOf(dateFormat.format(checkTime)));
        return "ticket";
    }

    @RequestMapping(value = "/boardingpass/{id}", method = RequestMethod.GET)
    public String showBoardingPass(Model model, HttpSession session, @PathVariable("id") Long id) {
        TicketInfo ticket = ticketService.getTicketInfo(id);
        model.addAttribute("ticket",ticket );
        Date checkTime= new Date(ticket.getFlight().getTime().getTime() - 1200000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        model.addAttribute("board",String.valueOf(dateFormat.format(checkTime)));
        return "boardingpass";
    }
}
