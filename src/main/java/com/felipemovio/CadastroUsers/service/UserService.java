package com.felipemovio.CadastroUsers.service;


import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

    public RegisterResponseDTO createUser(RegisterRequestDTO userRequestDTO) {
        Users user = modelMapper.map(userRequestDTO, Users.class);
        Users saved = usersRepository.save(user);
        return modelMapper.map(saved, RegisterResponseDTO.class);
    }

    public List<RegisterResponseDTO> getAllUsers(){
        return usersRepository.findAll().stream()
                .map(user -> modelMapper.map(user, RegisterResponseDTO.class))
                .collect(Collectors.toList());
    }

    public RegisterResponseDTO getUserById(Long id){
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado "));
        return modelMapper.map(user, RegisterResponseDTO.class);
    }

    public void deletar(Long id){
        usersRepository.deleteById(id);
    }


}
