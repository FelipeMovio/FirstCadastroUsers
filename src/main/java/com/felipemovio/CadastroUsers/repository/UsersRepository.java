package com.felipemovio.CadastroUsers.repository;

import com.felipemovio.CadastroUsers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
