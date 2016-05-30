package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by adelzamalutdinov on 30.05.16.
 */
@Controller
public class CheckInController {

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public String showPlaneSeats(Model model) {
        return "checkinplane";
    }
}
