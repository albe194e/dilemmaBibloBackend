package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.AdminUser;
//import kea.dilemmaspilbackend.admin.security.JwtResponse;
import kea.dilemmaspilbackend.admin.service.AdminUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class AdminController {
    private AdminUserService adminUserService;

    /*
    @PostMapping("/loginOld")
    public ResponseEntity<JwtResponse> loginOld(@RequestBody AdminUser adminUser) throws Exception {
        return new ResponseEntity<>(adminUserService.login(adminUser), HttpStatus.OK);
    }

     */
    @PostMapping("/login")
    public ResponseEntity<AdminUser> login(@RequestBody AdminUser adminUser) {
        System.out.println(adminUser.getUsername());
        Optional<AdminUser> adminUser1 = adminUserService.findAdminUser(adminUser.getUsername(), adminUser.getPassword());
        if(adminUser1.isPresent()){
        return ResponseEntity.ok(adminUser1.get());
        }
        else return ResponseEntity.ok(null);
    }
}