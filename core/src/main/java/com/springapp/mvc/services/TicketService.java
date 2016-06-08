package com.springapp.mvc.services;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<TicketInfo> getTicketsByBookAndPassenger(String book, String lastName) {
        List<PassengersInfo> passengers = passengersService.getPassengersByLastName(lastName);
        List<TicketInfo> tickets = null;
        BookInfo bookres = null;
        if (passengers != null) {
            for (PassengersInfo passenger : passengers) {
                if ((bookres = bookService.getBookByName(book) )!=null)
                    if ((tickets = ticketRepository.getTicketInfoByBookIdAndPassengerIdOrderById(
                            bookres.getId(), passenger.getId())) != null) {
                        flightService.updateCheckInInfo();
                        return tickets;
                    }
            }
        }
        return null;
    }

    @Transactional
    public boolean ticketCheckIn(Long ticket_id, String seat) {
        TicketInfo ticket = ticketRepository.findOne(ticket_id);
        if (ticket != null) {
            FlightInfo flight = flightService.getFlightById(ticket.getFlight().getId());
            if (flight != null && flight.getCheckInOpen()) {
                ticket.setSeat(seat);
                ticket.setCheck_in(true);
                flight.setCheckInNum(flight.getCheckInNum() + 1);
                return true;
            }
        }
        return false;
    }


    @Transactional
    public TicketInfo getTicketInfo(Long id) {
        return ticketRepository.findOne(id);
    }

    @Transactional
    public List<TicketInfo> getTickets() {
        return ticketRepository.findAll();
    }

    @Transactional
    public void addTicket(TicketInfo ticketInfo) {ticketRepository.save(ticketInfo);}

    @Transactional
    public void deleteTicket(Long id) {
        ticketRepository.delete(id);
    }

    @Transactional
    public List<TicketInfo> getTicketInfoByFlight(Long flight_id) {
        return ticketRepository.getTicketInfoByFlightId(flight_id);
    }

    @Transactional
    public Long generateNum() {
        long num = ticketRepository.findTop1ByOrderByIdDesc().getNum() + 1;
        return num;
    }
}
