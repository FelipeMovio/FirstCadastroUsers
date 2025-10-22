package com.felipemovio.CadastroUsers.dto.response;

import lombok.Data;

@Data
public class RegisterResponseDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String email;
}
