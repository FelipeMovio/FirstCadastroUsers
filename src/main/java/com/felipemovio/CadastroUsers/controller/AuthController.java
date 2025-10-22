package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.dto.request.LoginRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.LoginResponseDTO;
import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO dto) {
        authService.register(dto);
        return ResponseEntity.ok(Collections.singletonMap("message", "Usuário registrado com sucesso!"));

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(dto.getEmail()
                ,dto.getEmail());
        Authentication authentication = authenticationManager.authenticate(userAndPass);
        return null;
    }
}

