package com.web.app.repository;

import com.web.app.model.entity.AccountEntity;
import com.web.app.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
