package com.springapp.mvc.services;

import com.springapp.mvc.common.RouteInfo;
import com.springapp.mvc.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adelzamalutdinov on 05.05.16.
 */
@Service
public class RouteService {
    @Autowired
    RoutesRepository routesRepository;
    public RouteInfo getRoute(Long arrival_id, Long departure_id) {
        return routesRepository.findRouteInfoByArrivalIdAndDepartureId(arrival_id, departure_id);
    }
}
