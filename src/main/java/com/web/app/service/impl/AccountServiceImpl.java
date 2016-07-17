package com.web.app.service.impl;

import com.web.app.model.entity.AccountEntity;
import com.web.app.repository.AccountRepository;
import com.web.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public AccountEntity save(AccountEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public AccountEntity update(AccountEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public AccountEntity findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<AccountEntity> findAll() {
        return repository.findAll();
    }
}
