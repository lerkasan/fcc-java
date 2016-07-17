package com.web.app.controller;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(path = "/register", method = {RequestMethod.GET})
    public String register_GET() {
        return "views/register";
    }

    @RequestMapping(path = "/register", method = {RequestMethod.POST})
    public Object register_POST() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(null);
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
