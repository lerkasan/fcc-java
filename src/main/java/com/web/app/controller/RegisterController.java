package com.web.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {

   /* @RequestMapping(path = "/", method = { RequestMethod.GET} )
    public String register_GET() {
        return "views/register";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Object register_POST() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    } */
}
