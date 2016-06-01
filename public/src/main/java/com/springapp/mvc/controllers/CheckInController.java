package com.springapp.mvc.controllers;

import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.PlaneInfo;
import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.services.TicketService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Controller
public class CheckInController {

    private final Character[] ECONOMY = {'W', 'S', 'Y', 'B', 'H', 'K', 'L', 'M', 'N', 'Q', 'T', 'V', 'X'};
    private final Character[] BUSINESS = {'J', 'C', 'D', 'I', 'Z'};


    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/checkin/{id}", method = RequestMethod.GET)
    public String showPlaneSeats(Model model, HttpSession session, @PathVariable("id") Long id) {
        FlightInfo flight = ticketService.getTicketInfo(id).getFlight();
        TicketInfo ticket = ticketService.getTicketInfo(id);
        List<TicketInfo> list = ticketService.getTicketInfoByFlight(flight.getId());
        List<ArrayList<Boolean>> bookedSeats = null;
        Character ch = ticketService.getTicketInfo(id).getFlight_class().getType();
        int k = 1;
        if (Arrays.asList(ECONOMY).contains(ch)) {
            model.addAttribute("class", "economy");
            int num = flight.getPlane().getEconomy() / 6;
            bookedSeats = initBookedSeats(num, 6);
            k += flight.getPlane().getBusiness() / 4;
        }
        if (Arrays.asList(BUSINESS).contains(ch)) {
            model.addAttribute("class", "business");
            int num = flight.getPlane().getBusiness() / 4;
            bookedSeats = initBookedSeats(num, 4);
        }
        if (list != null) {
            for (TicketInfo ticketInfo : list) {
                if (!(ticketInfo.getSeat() == null) && !(ticketInfo.getSeat().length() == 0)) {
                    int j = ticketInfo.getSeat().charAt(ticketInfo.getSeat().length() - 1) - (int) 'A';
                    int i = Integer.valueOf(ticketInfo.getSeat().substring(0, 1)) - k;
                    if (ticketInfo.getSeat().length() == 3) {
                        i = Integer.valueOf(ticketInfo.getSeat().substring(0, 2)) - k;
                    }
                    if (i < bookedSeats.size()) {
                        ArrayList<Boolean> b = bookedSeats.get(i);
                        if (j < b.size()) {
                            b.set(j, true);
                            bookedSeats.set(i, b);
                        }
                    }
                }
            }
            model.addAttribute("seats", bookedSeats);
            model.addAttribute("num", k);
        }
            model.addAttribute("flight", flight);
            model.addAttribute("ticket", ticket);
            session.setAttribute("ticket", ticket);
            model.addAttribute("session", session);
        return "checkinplane";
    }

    private List<ArrayList<Boolean>> initBookedSeats(int num, int num1) {
        List<ArrayList<Boolean>> bookedSeats = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < num; i++) {
            ArrayList<Boolean> bookedSeat = new ArrayList<Boolean>();
            for (int j = 0; j < num1; j++) {
                bookedSeat.add(false);
            }
            bookedSeats.add(bookedSeat);
        }
        return bookedSeats;
    }

    @RequestMapping(value = "/checkinres/{id}/{seat}", method = RequestMethod.GET)
    public String checkInDone(Model model, HttpSession session, @PathVariable("seat") String seatnum,  @PathVariable("id") Long id) {
        ticketService.ticketCheckIn(id, seatnum);
        return "checkinresult";
    }
}
