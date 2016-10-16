package com.web.app.service.impl;

import com.web.app.config.BaseConfigTest;
import com.web.app.model.entity.UserEntity;
import com.web.app.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class UserServiceImplTest extends BaseConfigTest {

    @Autowired
    private UserService service;

    // Test:   UserEntity save(UserEntity entity);
    @Test
    @Rollback
    public void test_save() {
        //given
        UserEntity expectEntity = new UserEntity();
        expectEntity.setName("User");
        expectEntity.setPassword("222");

        //when
        UserEntity actualEntity = service.save(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    // Test:   UserEntity update(UserEntity entity);
    @Test
    @Rollback
    public void test_update() {
        //given
        UserEntity entity = new UserEntity();
        entity.setName("Admin");
        entity.setPassword("1111");

        UserEntity expectEntity = service.save(entity);
        expectEntity.setName("New");
        expectEntity.setPassword("123");

        //when
        UserEntity actualEntity = service.update(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    // Test:   void delete(Long id);
    @Test
    @Rollback
    public void test_delete() {
        //given
        UserEntity entity = new UserEntity();
        entity.setName("Admin");
        entity.setPassword("1111");

        UserEntity expectEntity = service.save(entity);

        //when
        service.delete(expectEntity.getId());

        //then
        assertEquals(0, service.findAll().size());
    }

    // Test:   UserEntity findById(Long id);
    @Test
    @Rollback
    public void test_findById() {
        //given
        UserEntity entity = new UserEntity();
        entity.setName("Admin");
        entity.setPassword("1111");

        UserEntity expectEntity = service.save(entity);

        //when
        UserEntity actualEntity = service.findById(expectEntity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);
    }

    // Test:  List<UserEntity> findAll();
    @Test
    @Rollback
    public void test_findAll() {
        //given
        UserEntity entity = new UserEntity();
        entity.setName("Admin");
        entity.setPassword("1111");

        service.save(entity);

        UserEntity entity_1 = new UserEntity();
        entity_1.setName("User");
        entity_1.setPassword("1111");
        service.save(entity_1);

        //when
        List<UserEntity> all = service.findAll();

        //then
        assertNotNull(all);
        assertEquals(2, all.size());
        assertTrue(all.contains(entity));
        assertTrue(all.contains(entity_1));
    }
}
