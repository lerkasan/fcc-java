package com.web.app.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String USERNAME_PATTERN = "^[A-Za-z_][A-Za-z0-9_]{4,15}$";

    public UsernameValidator() {
        this.pattern = Pattern.compile(USERNAME_PATTERN);
    }

    public boolean validate(final String username) {

        matcher = pattern.matcher(username);
        return matcher.matches();

    }
}