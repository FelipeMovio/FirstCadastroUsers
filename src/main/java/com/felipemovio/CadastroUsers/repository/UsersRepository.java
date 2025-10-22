package com.felipemovio.CadastroUsers.repository;

import com.felipemovio.CadastroUsers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<UserDetails> findByEmail(String username);

}
