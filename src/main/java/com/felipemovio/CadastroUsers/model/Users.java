package com.felipemovio.CadastroUsers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;

    @Column(name = "email", unique = true)
    private String email;
    private String senha;

    @Column(nullable = false)
    private String role = "ROLE_USER";  // ou "ROLE_ADMIN"
    //o campo role para distinguir usuários comuns de admins

}
