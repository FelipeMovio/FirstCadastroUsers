package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.dto.request.RegisterRequestDTO;
import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import com.felipemovio.CadastroUsers.security.JWTUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Lista todos os usuários (somente ADMIN)
    public List <RegisterResponseDTO> listarTodos(){
        return usersRepository.findAll()
                .stream()
                .map(u -> new RegisterResponseDTO(u.getId(), u.getNome(), u.getIdade(), u.getEmail()))
                .collect(Collectors.toList());
    }

    // Retorna usuário logado
    public RegisterResponseDTO getUsuarioLogado() {
        JWTUserData userData = getAuthenticatedUserData();
        Users user = usersRepository.findById(userData.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new RegisterResponseDTO(user.getId(), user.getNome(), user.getIdade(), user.getEmail());
    }


    // Atualiza dados do usuário logado
    public RegisterResponseDTO atualizarUsuarioLogado(String nome, Integer idade,String novaSenha) {
        JWTUserData userData = getAuthenticatedUserData();
        Users user = usersRepository.findById(userData.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (nome != null && !nome.isBlank()) user.setNome(nome);
        if (idade != null) user.setIdade(idade);
        if (novaSenha != null && !novaSenha.isBlank()) {
            user.setSenha(passwordEncoder.encode(novaSenha));
        }

        Users updated = usersRepository.save(user);
        return new RegisterResponseDTO(updated.getId(), updated.getNome(), updated.getIdade(), updated.getEmail());
    }

    // Deletar usuário logado
    public void deletarUsuarioLogado() {
        JWTUserData userData = getAuthenticatedUserData();
        Users user = usersRepository.findById(userData.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usersRepository.delete(user);
    }

    // Recupera dados do usuário autenticado via JWT
    private JWTUserData getAuthenticatedUserData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof JWTUserData userData) {
            return userData;
        }
        throw new RuntimeException("Usuário não autenticado");
    }
}
