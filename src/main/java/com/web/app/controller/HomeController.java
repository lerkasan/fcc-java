package com.web.app.controller;

import com.web.app.exception.UnauthorizedException;
import com.web.app.model.entity.AccountEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index_GET() {
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home_GET() {
        return "views/home";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register_GET() {
        return "views/register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register_POST(@RequestParam(value = "username", required = false) String username) {
        if ((username != null) && username.equals("12345")) {
            throw new UnauthorizedException("I am a crazy teapot");
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
