package com.web.app.model.entity;

import com.web.app.model.entity.templ.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountEntity extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Getter
    @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "firstName")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "lastName")
    private String lastName;

}
