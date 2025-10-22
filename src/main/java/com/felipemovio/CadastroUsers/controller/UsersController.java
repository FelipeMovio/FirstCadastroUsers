package com.felipemovio.CadastroUsers.controller;


import com.felipemovio.CadastroUsers.dto.response.UsersResponseDTO;
import com.felipemovio.CadastroUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    // ver todos usuarios
    @GetMapping
    public ResponseEntity<List<UsersResponseDTO>> verTodos(){
        return ResponseEntity.ok(userService.getAllUsers());
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
