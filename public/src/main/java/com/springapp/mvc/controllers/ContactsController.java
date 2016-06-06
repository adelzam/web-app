package com.springapp.mvc.controllers;

import com.springapp.mvc.forms.ContactFormBean;
import com.springapp.mvc.sender.SimpleMailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

/**
 * Created by Ann on 19.05.2016.
 */
@Controller
public class ContactsController {

    public static final String ATTR_CONTACT_FORM = "contactForm";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        request.setAttribute(ATTR_CONTACT_FORM, new ContactFormBean());
        return "contacts";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_CONTACT_FORM) ContactFormBean rfb,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contacts";
        }
        try {
            SimpleMailManager sender = new SimpleMailManager(rfb.getEmail());
            sender.sendQ(rfb.toString());
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "components/contactFormSu";
    }
}
