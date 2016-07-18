package com.web.app.controller;

import com.web.app.exception.UnauthorizedException;
import com.web.app.model.dto.AccountDTO;
import com.web.app.model.entity.AccountEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index_GET() {
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home_GET(Model model) {
        model.addAttribute("account", new AccountDTO());
        return "views/home";
    }

    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public String home_POST(@ModelAttribute AccountDTO account, Model model) {
        return "views/home";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register_GET(Model model) {
        model.addAttribute("account", new AccountDTO());
        return "views/register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register_POST(@ModelAttribute AccountDTO account, Model model) {
        String errorMsg = account.validate();
       if (!errorMsg.equals("")) {
           throw new UnauthorizedException(errorMsg);
       }
        return "views/register";
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public String info_GET() {
        return "views/info";
    }

    @RequestMapping(path = "/contacts", method = RequestMethod.GET)
    public String contacts_GET() {
        return "views/contacts";
    }

}
