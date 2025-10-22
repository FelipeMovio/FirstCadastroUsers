package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.request.LoginRequestDTO;
import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.LoginResponseDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements UserDetailsService {

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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}



