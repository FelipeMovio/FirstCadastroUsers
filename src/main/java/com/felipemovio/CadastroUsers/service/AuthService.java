package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterRequestDTO dto) {
        Users newUser = new Users();
        newUser.setSenha(passwordEncoder.encode(dto.getSenha()));
        newUser.setEmail(dto.getEmail());
        newUser.setNome(dto.getNome());
        newUser.setIdade(dto.getIdade());

        usersRepository.save(newUser);
    }

}



