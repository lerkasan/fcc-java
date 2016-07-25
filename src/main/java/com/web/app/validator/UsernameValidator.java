package com.web.app.validator;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsernameValidator implements ValidationService {

    private Pattern pattern;
    private Matcher matcher;

    private static final String USERNAME_PATTERN = "^[A-Za-z_][A-Za-z0-9_]{3,15}$";

    public UsernameValidator() {
        this.pattern = Pattern.compile(USERNAME_PATTERN);
    }

    public boolean validate(final String username) {

        matcher = pattern.matcher(username);
        return matcher.matches();

    }
}