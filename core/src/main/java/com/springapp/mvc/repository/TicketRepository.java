package com.springapp.mvc.repository;

import com.springapp.mvc.common.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketInfo, Long> {

    List<TicketInfo> getTicketInfoByBookIdAndPassengerIdOrderById(Long book_id, Long passenger_id);

    List<TicketInfo> getTicketInfoByFlightId(Long flight_id);
}
