package com.springapp.mvc.controllers;

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
        return "searchflight";
    }
}
