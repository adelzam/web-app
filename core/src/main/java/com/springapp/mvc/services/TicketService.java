package com.springapp.mvc.services;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private PassengersService passengersService;

    @Autowired
    private FlightService flightService;

    public List<TicketInfo> getTicketsByBookAndPassenger(String book, String lastName){
        List<PassengersInfo> passengers = passengersService.getPassengersByLastName(lastName);
        List<TicketInfo> tickets = null;
        if (passengers!=null) {
            for (PassengersInfo passenger : passengers) {
                if((tickets=ticketRepository.getTicketInfoByBookIdAndPassengerIdOrderById(
                        bookService.getBookByName(book).getId(),
                        passenger.getId()))!=null) {
                    flightService.updateCheckInInfo();
                    return tickets;
                }
            }
        }
        return null;
    }

    public boolean ticketCheckIn(Long ticket_id, String seat) {
        TicketInfo ticket = ticketRepository.findOne(ticket_id);
        if (ticket!=null) {
            FlightInfo flight = flightService.getFlightById(ticket.getFlight().getId());
            if(flight!=null&&flight.getCheckInOpen()){
                ticket.setSeat(seat);
                flight.setCheckInNum(flight.getSeats()+1);
                return true;
            }
        }
        return false;
    }
}
