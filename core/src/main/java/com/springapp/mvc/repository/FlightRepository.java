package com.springapp.mvc.repository;

import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.common.RouteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 05.05.16.
 */
public interface FlightRepository extends JpaRepository<FlightInfo, Long>{
    List<FlightInfo> getFlightInfoByRoute(RouteInfo routeInfo);
}
