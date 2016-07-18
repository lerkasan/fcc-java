package com.web.app.model.dto;

import com.web.app.validator.NameValidator;
import com.web.app.validator.UsernameValidator;
import com.web.app.validator.ValidationService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dozer.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@EqualsAndHashCode
public class AccountDTO {

    private Long id;

    private String username;

    private String password;

    private String password2;

    private String email;

    private String firstName;

    private String lastName;

    @Autowired
    ValidationService usernameValidator;

    @Autowired
    ValidationService nameValidator;

    public AccountDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String validate() {
        boolean valid = true;
        String errorMsg = "";

        if ((getUsername() != null) && !usernameValidator.validate(getUsername())) {
            valid = false;
            errorMsg += " Incorrect username format";
        }
        if ((getFirstName() != null) && !nameValidator.validate(getFirstName())) {
            valid = false;
            errorMsg += " Incorrect first name format";
        }

        if ((getLastName() != null) && !nameValidator.validate(getLastName())) {
            valid = false;
            errorMsg += " Incorrect last name format";
        }

        if (!getPassword().equals(getPassword2()) || (getPassword().length() < 8)) {
            valid = false;
            errorMsg += " Incorrect password format";
        }
        try {
            System.out.print("Before exception");
            InternetAddress emailAddress = new InternetAddress(getEmail());
            emailAddress.validate();
        } catch (AddressException e) {
            valid = false;
            e.printStackTrace();
            errorMsg += " Incorrect e-mail format";
        }
        return errorMsg;
    }
}

