package com.web.app.model.dto;

import com.web.app.model.entity.AccountEntity;
import com.web.app.service.AccountService;
import com.web.app.validator.Unique;
import com.web.app.validator.ValidationService;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@EqualsAndHashCode
//@FieldMatch(first = "password", second = "password2", message = "The password fields must match")
@ScriptAssert(lang = "javascript", script = "_this.password == _this.password2")
public class AccountDTO {

    private Long id;

    @NotEmpty
    @Size(min=4, max=15)
    private String username;

    @NotEmpty
    @Size(min=8)
    private String password;

    @NotEmpty
    @Size(min=8)
    private String password2;

    @NotEmpty
    @Email
    private String email;

    private String firstName;

    private String lastName;

    @Autowired
    ValidationService usernameValidator;

    @Autowired
    ValidationService nameValidator;

    @Autowired
    AccountService accountService;

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

    public String validateUnique() {
        Class<?> cls = this.getClass();
        Class<?> serviceCls = accountService.getClass();
        Field[] fields = cls.getFields();
        AccountEntity foundAccount = null;
        String error = "";

        for (Field field : fields) {
            if (field.isAnnotationPresent(Unique.class)) {
                try {
                    Method findByMethod = serviceCls.getMethod("findBy" + field.getName());
                    Method getter = cls.getMethod("get" + field.getName());
                    Object fieldValue = getter.invoke(this);
                    foundAccount = (AccountEntity) findByMethod.invoke(this, fieldValue);
                    if (foundAccount != null) {
                        error += field.getName() + " is already registered. Try another "+field.getName();
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
        /* if (!getPassword().equals(getPassword2()) || (getPassword().length() < 8)) {
            valid = false;
            errorMsg += " Incorrect password format";
        } */
       /* try {
            System.out.print("Before exception");
            InternetAddress emailAddress = new InternetAddress(getEmail());
            emailAddress.validate();
        } catch (AddressException e) {
            valid = false;
            e.printStackTrace();
            errorMsg += " Incorrect e-mail format";
        } */
        return errorMsg;
    }
}

