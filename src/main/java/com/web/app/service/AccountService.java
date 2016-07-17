package com.web.app.service;

import com.web.app.model.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    AccountEntity save(AccountEntity entity);

    AccountEntity update(AccountEntity entity);

    void delete(Long id);

    AccountEntity findById(Long id);

    List<AccountEntity> findAll();
}
