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

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Object register_POST(@Valid @ModelAttribute("account") AccountDTO account, Model model, BindingResult bindingResult) {
        beanFactory.autowireBean(account);
        String errorMsg = account.validate();
        if ((!errorMsg.equals("")) || (bindingResult.hasErrors())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMsg);
        } else {
            AccountEntity accountEnt = new AccountEntity();
            accountEnt.setUsername(account.getUsername());
            accountEnt.setPassword(account.getPassword());
            accountEnt.setEmail(account.getEmail());
            accountEnt.setFirstName(account.getFirstName());
            accountEnt.setLastName(account.getLastName());
            accountService.save(accountEnt);
        }
        model.addAttribute("account", new AccountDTO());
        return "views/register";
    }

}
