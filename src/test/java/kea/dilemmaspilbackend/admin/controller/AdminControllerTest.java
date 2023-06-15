package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.AdminUser;
import kea.dilemmaspilbackend.admin.repository.AdminUserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class AdminControllerTest {

    @Autowired
    AdminUserRepository adminUserRepository;

    AdminUser adminUser;


    @BeforeEach
    void setUp() {
        adminUser = new AdminUser();
        adminUser.setUsername("test");
        adminUser.setPassword("test");
        adminUserRepository.save(adminUser);
    }


    @Test
    void login() {

        String username = "test";
        String password = "test";

        Optional<AdminUser> checkUser = adminUserRepository.findAdminUserByUsernameAndPassword(username,password);

        assertTrue(checkUser.isPresent());


    }
}
