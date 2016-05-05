package com.springapp.mvc.repository;

import com.springapp.mvc.common.RouteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutesRepository extends JpaRepository<RouteInfo, Long> {
        RouteInfo findRouteInfoByArrivalIdAndDepartureId(Long arrival_id, Long departure_id);
}
