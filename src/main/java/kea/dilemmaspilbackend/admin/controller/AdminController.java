package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.AdminUser;
import kea.dilemmaspilbackend.admin.security.JwtResponse;
import kea.dilemmaspilbackend.admin.service.AdminUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class AdminController {
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AdminUser adminUser) throws Exception {
        return new ResponseEntity<>(adminUserService.login(adminUser), HttpStatus.OK);
    }
}