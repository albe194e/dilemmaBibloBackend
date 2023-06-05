package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.AdminUser;
//import kea.dilemmaspilbackend.admin.security.JwtResponse;
import kea.dilemmaspilbackend.admin.service.AdminUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

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
        if (adminUser1.isPresent()) {
            return ResponseEntity.ok(adminUser1.get());
        } else return ResponseEntity.ok(null);
    }

    @GetMapping("/api/get/findall/admin")
    public ResponseEntity<Set<AdminUser>> getAllAdmins() {
       Set<AdminUser> set = new HashSet<>();
         adminUserService.findAll().forEach(set::add);
       return ResponseEntity.ok(set);
    }

    @PostMapping("/api/post/create/admin")
    public ResponseEntity<AdminUser> createAdmin(@RequestBody AdminUser adminUser) {
        return new ResponseEntity<>(adminUserService.save(adminUser), HttpStatus.OK);
    }

    @DeleteMapping("/api/post/delete/{id}/admin")
    @Transactional
    public ResponseEntity<Map<String, String>> deleteAdmin(@PathVariable Integer id) {

        adminUserService.deleteAdminUserById(id);

        Map<String, String> msg = new HashMap<>();
        msg.put("Message", "Deleted admin with id: " + id);
        return ResponseEntity.ok(msg);
    }
}