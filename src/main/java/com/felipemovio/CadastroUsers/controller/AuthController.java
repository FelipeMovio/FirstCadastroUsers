package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.dto.LoginRequestDTO;
import com.felipemovio.CadastroUsers.dto.LoginResponseDTO;
import com.felipemovio.CadastroUsers.dto.UsersRequestDTO;
import com.felipemovio.CadastroUsers.security.JwtTokenProvider;
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

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UsersRequestDTO dto) {
        authService.register(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}

