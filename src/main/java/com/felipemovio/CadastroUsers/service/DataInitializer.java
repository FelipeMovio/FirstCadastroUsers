package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.model.Role;
import com.felipemovio.CadastroUsers.model.Users;
import com.felipemovio.CadastroUsers.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner createAdminUser(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verifica se já existe um usuário admin
            if (usersRepository.findByEmail("admin@admin.com").isEmpty()) {
                Users admin = Users.builder()
                        .nome("Administrador")
                        .idade(30)
                        .email("admin@admin.com")
                        .senha(passwordEncoder.encode("123")) // senha padrão
                        .roles(Set.of(Role.ROLE_ADMIN))
                        .build();

                usersRepository.save(admin);
                System.out.println("✅ Usuário ADMIN criado automaticamente: admin@admin.com / 123");
            } else {
                System.out.println("ℹ️ Usuário ADMIN já existe. Nenhuma ação necessária.");
            }
        };
    }
}
