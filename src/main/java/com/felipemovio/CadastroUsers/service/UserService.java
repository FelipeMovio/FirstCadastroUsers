package com.felipemovio.CadastroUsers.service;


import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

}
