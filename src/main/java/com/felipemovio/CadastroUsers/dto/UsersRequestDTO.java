package com.felipemovio.CadastroUsers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsersRequestDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private Integer idade;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
}
