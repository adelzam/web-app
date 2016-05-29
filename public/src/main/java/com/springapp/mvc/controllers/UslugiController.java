package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ann on 19.05.2016.
 */
@Controller
public class UslugiController {
    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "uslugi";
    }
}
