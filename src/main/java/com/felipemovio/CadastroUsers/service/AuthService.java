package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.model.Role;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        if (usersRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        Role role;
        if (dto.getRole() != null) {
            role = dto.getRole();
        } else {
            role = Role.ROLE_USER;
        }


        Users newUser = Users.builder()
                .nome(dto.getNome())
                .idade(dto.getIdade())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .roles(Set.of(role))
                .build();

        Users saved = usersRepository.save(newUser);

        return new RegisterResponseDTO(saved.getId(), saved.getNome(), saved.getIdade(), saved.getEmail());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}



