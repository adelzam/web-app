package com.springapp.mvc.controllers;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.common.TicketInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.form.UpdateFormBean;
import com.springapp.mvc.sender.SimpleMailManager;
import com.springapp.mvc.services.BookService;
import com.springapp.mvc.services.TicketService;
import com.springapp.mvc.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ann on 19.05.2016.
 */
@Controller
@RequestMapping(value = "/cabinet")
public class CabinetController {

    public static final String ATTR_UPDATE_FORM = "updateForm";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        UserInfo user = userService.getAutUser();
        model.addAttribute("user", user);
        model.addAttribute("books", bookService.getBookByLogin(user.getLogin()));
        return "cabinet";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String loadBook(@PathVariable("id") String id, ModelMap model) {

        BookInfo book = bookService.getBookByName(id);

        model.addAttribute("book", book.getName());
        model.addAttribute("tickets", ticketService.getTicketsByBook(book));
        return "cabinetTicket";
    }


    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String changePI(ModelMap model) {
        request.setAttribute("user", userService.getAutUser());
        request.setAttribute(ATTR_UPDATE_FORM, new UpdateFormBean());
        return "registrationUpdate";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changePIP(
            @Valid @ModelAttribute(ATTR_UPDATE_FORM) UpdateFormBean ufb,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registrationUpdate";
        }
//        Изменение информации пользователя
        UserInfo user = userService.getAutUser();
        user.setFio(ufb.getFio());
        user.setPhone(ufb.getPhone());
        user.setHashPass(DigestUtils.md5Hex(ufb.getPassword()));
//      Отправка письма об изменении пароля
        try {
            SimpleMailManager sender = new SimpleMailManager(user.getLogin());
            sender.changePass(ufb.getPassword());
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
        userService.update(user);
        request.setAttribute("user", userService.getAutUser());
        return "registrationUpdate";
    }
}
