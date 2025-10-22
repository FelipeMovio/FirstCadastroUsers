package com.felipemovio.CadastroUsers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Integer idade;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;
}
