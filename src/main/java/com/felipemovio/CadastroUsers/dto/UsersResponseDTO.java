package com.felipemovio.CadastroUsers.dto;

import lombok.Data;

@Data
public class UsersResponseDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private String senha;
}
