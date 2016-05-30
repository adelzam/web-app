package com.springapp.mvc.controllers;

import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.services.TicketService;
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

/**
 * Created by adelzamalutdinov on 29.05.16.
 */
@Controller
@RequestMapping("/webcheckin")
public class CheckInPageController {

    private static final String ATTR_NEWCHECKIN_FORM = "checkInForm";
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET)
    public String printCheckInForm() {
        request.setAttribute(ATTR_NEWCHECKIN_FORM,new NewCheckInSearchForm());
        return "checkIn";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String printCheckInList(@Valid @ModelAttribute(ATTR_NEWCHECKIN_FORM) NewCheckInSearchForm checkInSearchForm,
                                   BindingResult bindingResult, ModelMap model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "checkIn";
        }
        List<TicketInfo> list = ticketService.getTicketsByBookAndPassenger(checkInSearchForm.getBook(), checkInSearchForm.getName());
        model.addAttribute("tickets", list);
        model.addAttribute("book", checkInSearchForm.getBook());
        return "searchcheckIn";
    }

}
