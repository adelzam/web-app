package com.springapp.mvc.aspects;

import com.springapp.mvc.common.AirportInfo;
import com.springapp.mvc.services.AirportService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
public class AirportListAspect {

    private static final String DEPARTURE_LIST = "departure";
    private static final String ARRIVAL_LIST = "arrival";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AirportService airportService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeAirportList)")
    public void includeAirportListMethod() {

    }

    /**
     * render of airport list
     */
    @Before("includeAirportListMethod()")
    public void includeTopGoods() {
        List<AirportInfo> airportInfos = airportService.getAirports();
        request.setAttribute(ARRIVAL_LIST, airportInfos);
        System.out.println(airportInfos==null);
        request.setAttribute(DEPARTURE_LIST, airportInfos);
    }
}
