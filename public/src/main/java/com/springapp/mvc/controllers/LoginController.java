package com.springapp.mvc.controllers;

import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ann on 02.06.2016.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Boolean error) {
        request.setAttribute("error", error);
        return "login";
    }
}
