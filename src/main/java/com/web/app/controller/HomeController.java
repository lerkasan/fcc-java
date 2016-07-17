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
        boolean valid = true;
        if (account != null) {
            if (!account.getPassword().equals(account.getPassword2()) || (account.getPassword().length() < 8)) {
                valid = false;
            }
            try {
                InternetAddress emailAddress = new InternetAddress(account.getEmail());
            } catch (AddressException e) {
                valid = false;
            }
            if () {

            }
        }
        return "views/register";
    }
    /*public String register_POST(@RequestParam(value = "username", required = false) String username) {
    public String register_POST(@RequestParam(value = "username", required = false) String username) {
        if ((username != null) && username.equals("12345")) {
            throw new UnauthorizedException("I am a crazy teapot");
        }
        return "views/register";
    } */

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public String info_GET() {
        return "views/info";
    }

    @RequestMapping(path = "/contacts", method = RequestMethod.GET)
    public String contacts_GET() {
        return "views/contacts";
    }

}
