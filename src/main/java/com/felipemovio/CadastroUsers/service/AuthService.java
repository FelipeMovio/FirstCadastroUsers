package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        if (usersRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já está em uso.");
        }

        Users user = new Users(
                null, // ID será gerado automaticamente
                dto.getNome(),
                dto.getIdade(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getSenha()),
                "ROLE_USER"
        );

        usersRepository.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getSenha(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}

