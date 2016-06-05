package com.springapp.mvc.controllers;

import com.springapp.mvc.common.FlightClassInfo;
import com.springapp.mvc.form.NewFlightSearchForm;
import com.springapp.mvc.common.FlightInfo;
import com.springapp.mvc.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/search")
public class FlightSearchController {

    @Autowired
    private HttpServletRequest request;

    private static final String ATTR_NEWSEARCH_FORM = "searchForm";

    @Autowired
    private FlightService flightService;

    @RequestMapping(method = RequestMethod.GET)
    public String printFlightSearchForm() {
        request.setAttribute(ATTR_NEWSEARCH_FORM, new NewFlightSearchForm());
        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String printFlightList(@Valid @ModelAttribute(ATTR_NEWSEARCH_FORM) NewFlightSearchForm form,
                                  BindingResult bindingResult, ModelMap model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "search";
        }
        List<FlightInfo> list = flightService.findFlight(form.getDeparture(), form.getArrival(), form.getDate());
        model.addAttribute("flight", list);
        model.addAttribute("arr", form.getArrival());
        model.addAttribute("dep", form.getDeparture());
        model.addAttribute("date", form.getDate());
        model.addAttribute("passnum", form.getPassnum());
        return "search/searchflight";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public String resultSearch(ModelMap model, HttpServletRequest request) throws ParseException {
        String dep = request.getParameter("dep");
        String arr = request.getParameter("arr");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(request.getParameter("date"));
        String num = request.getParameter("num");
        List<FlightInfo> list = flightService.findFlight(dep, arr, date);
        List<FlightClassInfo> classInfos = flightService.getFlightClassOrderById();
        HashMap<Long, ArrayList<BigDecimal>> costmap = new HashMap<Long, ArrayList<BigDecimal>>();
        if (list != null) {
            for (FlightInfo flightInfo : list) {
                ArrayList<BigDecimal> cost = new ArrayList<BigDecimal>();
                for (int i = 0; i < 4; i++) {
                    cost.add(BigDecimal.valueOf(flightInfo.getRoute().getCost())
                            .multiply(classInfos.get(i).getCost()
                            .multiply(BigDecimal.valueOf(Long.parseLong(num)))));
                }
                costmap.put(flightInfo.getId(), cost);
            }
        }
        model.addAttribute("flight", list);
        model.addAttribute("cost", costmap);
        model.addAttribute("arr", arr);
        model.addAttribute("dep", dep);
        model.addAttribute("date", request.getParameter("date"));
        model.addAttribute("num", num);
        model.addAttribute("classindexlist", flightService.getFlightClassOrderById());
        return "search/searchflight";
    }
}
