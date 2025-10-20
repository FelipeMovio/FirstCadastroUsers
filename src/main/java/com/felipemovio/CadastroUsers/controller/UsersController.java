package com.felipemovio.CadastroUsers.controller;


import com.felipemovio.CadastroUsers.dto.UsersRequestDTO;
import com.felipemovio.CadastroUsers.dto.UsersResponseDTO;
import com.felipemovio.CadastroUsers.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cadastro")
public class UsersController {

    @Autowired
    private UserService userService;

    // ver todos usuarios
    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> verTodos(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // criar usuario
    @PostMapping
    public ResponseEntity<UsersResponseDTO> criarUser(@RequestBody @Valid UsersRequestDTO dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    // ver um usuario
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> verUm(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // deletar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        userService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
