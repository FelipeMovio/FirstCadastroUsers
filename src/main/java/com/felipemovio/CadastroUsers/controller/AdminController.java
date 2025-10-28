package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/panel")
    public ResponseEntity<List<RegisterResponseDTO>> allUsers(){
        List<RegisterResponseDTO> users = usersService.listarTodos();
        return ResponseEntity.ok(users);
    }
}
