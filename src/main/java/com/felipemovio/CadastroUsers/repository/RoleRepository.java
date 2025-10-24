package com.felipemovio.CadastroUsers.repository;

import com.felipemovio.CadastroUsers.model.User_Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User_Roles, Long> {
}
