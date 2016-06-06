package com.springapp.mvc.services;

import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    RoutesRepository routesRepository;

    @Transactional
    public RouteInfo getRoute(Long departure_id, Long arrival_id) {
        return routesRepository.findRouteInfoByArrivalIdAndDepartureId(arrival_id, departure_id);
    }

    @Transactional
    public List<RouteInfo> getRoutes() {
        return routesRepository.findAll();
    }

}
