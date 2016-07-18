package com.web.app.validator;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NameValidator implements ValidationService {

    private Pattern pattern;
    private Matcher matcher;

    private static final String USERNAME_PATTERN = "^[A-Za-z ]{2,25}$";

    public NameValidator() {
        this.pattern = Pattern.compile(USERNAME_PATTERN);
    }

    public boolean validate(final String name) {

        matcher = pattern.matcher(name);
        return matcher.matches();
    }
}