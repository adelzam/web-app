package com.springapp.mvc.repository;

import com.springapp.mvc.common.FlightClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightClassRepository extends JpaRepository<FlightClassInfo, Long> {
        List<FlightClassInfo> getAllByOrderById();
}
