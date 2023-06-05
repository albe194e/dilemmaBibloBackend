package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.AdminUser;
import kea.dilemmaspilbackend.admin.repository.AdminUserRepository;
import kea.dilemmaspilbackend.admin.security.JWTUtilToken;
import kea.dilemmaspilbackend.admin.security.JwtDetailsService;
import kea.dilemmaspilbackend.admin.service.AdminUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
