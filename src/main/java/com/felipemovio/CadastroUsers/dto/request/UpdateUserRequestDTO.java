package com.felipemovio.CadastroUsers.dto.request;

import lombok.Data;

@Data
public class UpdateUserRequestDTO {
    private String nome;
    private Integer idade;
    private String novaSenha;
}
