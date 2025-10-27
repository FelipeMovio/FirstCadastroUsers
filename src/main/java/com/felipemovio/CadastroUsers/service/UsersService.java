package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List <Users> verTodos(){
        return usersRepository.findAll();
    }

    public RegisterResponseDTO editarUser(String email,RegisterRequestDTO dto){


    }
}
