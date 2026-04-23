package com.irvin.pos.controllers;

import com.irvin.pos.dtos.LoginRequestDTO;
import com.irvin.pos.dtos.LoginResponseDTO;
import com.irvin.pos.entities.UserAccount;
import com.irvin.pos.entities.UserRole;
import com.irvin.pos.repositories.UserAccountRepository;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserAccountRepository userAccountRepository;

    public AuthController(AuthenticationManager authenticationManager, UserAccountRepository userAccountRepository) {
        this.authenticationManager = authenticationManager;
        this.userAccountRepository = userAccountRepository;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO request, HttpServletRequest httpRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        httpRequest
            .getSession(true)
            .setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

        String name = request.username();
        String email = request.username();
        UserRole role = UserRole.CAJERO;

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            String principalUsername = userDetails.getUsername();
            UserAccount account = userAccountRepository.findByUsername(principalUsername).orElse(null);

            if (account != null) {
                name = account.getName() != null ? account.getName() : principalUsername;
                email = account.getEmail() != null ? account.getEmail() : principalUsername;
                role = account.getRole() != null ? account.getRole() : UserRole.CAJERO;
            } else {
                name = principalUsername;
                email = principalUsername;
            }
        }

        String token = UUID.randomUUID().toString();
        return new LoginResponseDTO(token, name, email, role.name());
    }

    @GetMapping("/me")
    public LoginResponseDTO me(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return new LoginResponseDTO("", "", "", "");
        }

        String username = authentication.getName();
        UserAccount account = userAccountRepository.findByUsername(username).orElse(null);

        if (account == null) {
            return new LoginResponseDTO("", username, username, UserRole.CAJERO.name());
        }

        String role = account.getRole() != null ? account.getRole().name() : UserRole.CAJERO.name();
        return new LoginResponseDTO("", account.getName(), account.getEmail(), role);
    }
}
