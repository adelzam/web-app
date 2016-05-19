package com.springapp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ann on 19.05.2016.
 */
@Controller
public class NewsController {

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "news";
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public String renderGoodPage(@PathVariable("id") Long goodId, ModelMap model) {
       return "newsPage";
    }
}
