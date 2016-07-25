package com.web.app.controller;

import com.web.app.exception.UnauthorizedException;
import com.web.app.model.dto.AccountDTO;
import com.web.app.model.entity.AccountEntity;
import com.web.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @RequestMapping(method = RequestMethod.GET)
    public String index_GET() {
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home_GET(Model model) {
        model.addAttribute("login", new AccountDTO());
        return "views/home";
    }

    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public Object home_POST(@ModelAttribute("login")  AccountDTO login, Model model) {
        model.addAttribute("login", new AccountDTO());
        AccountEntity accountEnt = accountService.findByEmailAndPassword(login.getEmail(), login.getPassword());
        if (accountEnt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or password are incorrect.");
        } /*else {
            return ResponseEntity.status(HttpStatus.OK).body("Succesful login with username "+accountEnt.getUsername());
        } */
        return "views/home";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register_GET(Model model) {
        model.addAttribute("account", new AccountDTO());
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
