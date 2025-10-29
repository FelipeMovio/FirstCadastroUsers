package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.dto.request.UpdateUserRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.security.JWTUserData;
import com.felipemovio.CadastroUsers.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService userService;

    @GetMapping("/me")
    public ResponseEntity<RegisterResponseDTO> verProprioUsuario() {
        return ResponseEntity.ok(userService.getUsuarioLogado());
    }

    @PutMapping("/me")
    public RegisterResponseDTO updateCurrentUser(
            @RequestBody UpdateUserRequestDTO dto
    ) {
        return userService.atualizarUsuarioLogado( dto.getNome(), dto.getIdade(), dto.getNovaSenha());
    }
}