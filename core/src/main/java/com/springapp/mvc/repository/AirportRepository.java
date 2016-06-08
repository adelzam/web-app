package com.springapp.mvc.repository;

import com.springapp.mvc.common.AirportInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 05.05.16.
 */
public interface AirportRepository extends JpaRepository<AirportInfo, Long> {
    AirportInfo getAirportInfoByName(String name);

    List<AirportInfo> getAirportInfoByCity(String city);
}
