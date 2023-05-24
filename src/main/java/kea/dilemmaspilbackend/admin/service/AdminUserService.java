package kea.dilemmaspilbackend.admin.service;

import kea.dilemmaspilbackend.admin.model.AdminUser;
import kea.dilemmaspilbackend.admin.repository.AdminUserRepository;
/*
import kea.dilemmaspilbackend.admin.security.JWTUtilToken;
import kea.dilemmaspilbackend.admin.security.JwtDetailsService;
import kea.dilemmaspilbackend.admin.security.JwtResponse;

 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AdminUserService {

    /*
    @Value("${salt}") String salt;


     */
    /*
    private final AuthenticationManager authenticationManager;
    private final JWTUtilToken jwtUtilToken;
    private final JwtDetailsService jwtDetailsService;

     */
    @Autowired
    AdminUserRepository adminRepo;

    /*
    public AdminUserService(AuthenticationManager authenticationManager, JWTUtilToken jwtUtilToken, JwtDetailsService jwtDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtilToken = jwtUtilToken;
        this.jwtDetailsService = jwtDetailsService;
    }

     */

    /*
    public JwtResponse login(AdminUser adminUser) throws Exception {
        authenticate(adminUser.getUsername(), adminUser.getPassword());

        final UserDetails userDetails = jwtDetailsService
                .loadUserByUsername(adminUser.getUsername());

        final String token = jwtUtilToken.generateToken(userDetails);

        return new JwtResponse(token);
    }

     */

    /*
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

     */

    public Optional<AdminUser> findAdminUser(String username, String password) {
        return adminRepo.findAdminUserByUsernameAndPassword(username, password);
    }



}
