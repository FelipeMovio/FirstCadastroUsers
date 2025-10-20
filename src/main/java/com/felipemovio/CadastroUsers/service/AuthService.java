package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.UsersRequestDTO;
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

    public void register(UsersRequestDTO dto) {
        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setNome(dto.getNome());
        user.setIdade(dto.getIdade());
        user.setSenha(passwordEncoder.encode(dto.getSenha()));
        user.setRole("ROLE_USER");
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

