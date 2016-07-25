package com.web.app.model.dto;

import com.web.app.model.entity.AccountEntity;
import com.web.app.service.AccountService;
import com.web.app.validator.Unique;
import com.web.app.validator.ValidationService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@NoArgsConstructor
@EqualsAndHashCode
//@FieldMatch(first = "password", second = "password2", message = "The password fields must match")
@ScriptAssert(lang = "javascript", script = "_this.password == _this.password2")
public class AccountDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotEmpty(message="Username can't be empty")
    @Unique
    @Size(min=4, max=15, message = "Username length must be from 4 to 15 chars")
  //  @Pattern(regexp = "[A-Za-z][A-Za-z0-9_]{4,15}$", message = "Please use only letters, numbers and underscopes in username")
    private String username;

    @Getter
    @Setter
    @NotEmpty(message="Password can't be empty")
    @Size(min=8, message = "Password length must be 8 or more chars")
    private String password;

    @Getter
    @Setter
    @NotEmpty(message="Password confirmation can't be empty")
    @Size(min=8, message = "Password confirmation length must be 8 or more chars")
    private String password2;

    @Getter
    @Setter
    @NotEmpty(message="E-mail can't be empty")
    @Unique
    @Email(message="Wrong e-mail format")
    private String email;

    //@Pattern(regexp = "[A-Za-z ]", message = "Please use only letters and space in first name")
    @Getter
    @Setter
    private String firstName;

 //  @Pattern(regexp = "[A-Za-z ]", message = "Please use only letters and space in last name")
    @Getter
    @Setter
    private String lastName;

    @Autowired
    ValidationService usernameValidator;

    @Autowired
    ValidationService nameValidator;

    @Autowired
    private AccountService accountService;

    public String validateUnique() {
        Class<?> cls = this.getClass();
        Class<?> serviceCls = accountService.getClass();
        Field[] fields = cls.getDeclaredFields();
        AccountEntity foundAccount = null;
        String error = "";

        for (Field field : fields) {
            if (field.isAnnotationPresent(Unique.class)) {
                try {
                    String fieldNameLowcase = field.getName();
                    String fieldName = fieldNameLowcase.substring(0, 1).toUpperCase() + fieldNameLowcase.substring(1);
                    Method findByMethod = serviceCls.getMethod("findBy" + fieldName, String.class);
                    Method getter = cls.getMethod("get" + fieldName);
                    Object fieldValue = getter.invoke(this);
                    foundAccount = (AccountEntity) findByMethod.invoke(accountService, fieldValue);
                    if (foundAccount != null) {
                        error += " " + field.getName() + " is already registered. Try another " + field.getName() + ".";
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return error;
    }

    public String validate() {
        boolean valid = true;
        String errorMsg = "";

        if ((getUsername() != null) && !usernameValidator.validate(getUsername())) {
            valid = false;
            errorMsg += " Incorrect username format.";
        }
        if ((getFirstName() != null) && !nameValidator.validate(getFirstName())) {
            valid = false;
            errorMsg += " Incorrect first name format.";
        }

        if ((getLastName() != null) && !nameValidator.validate(getLastName())) {
            valid = false;
            errorMsg += " Incorrect last name format.";
        }
        errorMsg += validateUnique();
        return errorMsg;
    }
}

