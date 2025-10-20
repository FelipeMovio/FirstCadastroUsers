package com.felipemovio.CadastroUsers.service;


import com.felipemovio.CadastroUsers.dto.UsersRequestDTO;
import com.felipemovio.CadastroUsers.dto.UsersResponseDTO;
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

    public UsersResponseDTO createUser(UsersRequestDTO userRequestDTO) {
        Users user = modelMapper.map(userRequestDTO, Users.class);
        Users saved = usersRepository.save(user);
        return modelMapper.map(saved, UsersResponseDTO.class);
    }

    public List<UsersResponseDTO> getAllUsers(){
        return usersRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UsersResponseDTO.class))
                .collect(Collectors.toList());
    }

    public UsersResponseDTO getUserById(Long id){
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado "));
        return modelMapper.map(user, UsersResponseDTO.class);
    }

    public void deletar(Long id){
        usersRepository.deleteById(id);
    }


}
